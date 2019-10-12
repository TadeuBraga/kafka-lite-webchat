<template>
  <div class="home">
    <b-jumbotron class="container p-3">
      <MessageCard
        :message="message"
        v-for="message in messages"
        :key="message.content+message.time"
      />
    </b-jumbotron>
    <b-col sm="12">
      <MessageForm :sendMessage="sendMessage" />
    </b-col>
  </div>
</template>

<script>
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
import axios from "axios";
import { mapState, mapActions } from "vuex";

import MessageCard from "@/components/MessageCard.vue";
import MessageForm from "@/components/MessageForm.vue";

export default {
  components: {
    MessageCard,
    MessageForm
  },
  mounted() {
    this.initializeSocket();
  },
  methods: {
    ...mapActions(["addMessage"]),
    async initializeSocket() {
      const url = "http://localhost:9000/socket";
      const ws = new SockJS(url);
      let client = Stomp.over(ws);
      await client.connect({ "client-id": "my-client-id" }, error => {
        client.subscribe("/chat", msg => {
          let message = JSON.parse(msg.body);
          message.time = new Date(message.time);
          if(this.isLastMessageFromTheSameUser(this.username)) {
            const index = this.messages.length-1;
            let previousMessage = Object.assign({}, this.messages[index]);
            if(previousMessage.contents) {
              previousMessage.contents.push(message.content);
              previousMessage.times.push(message.time);
            } else {
              previousMessage.merged = true;
              previousMessage.contents = [previousMessage.content, message.content];
              previousMessage.times = [previousMessage.time, message.time];
            }
            //replaceMessage index
          } else {
            this.addMessage(message);
          }
          
        });
      });
    },
    isLastMessageFromTheSameUser(username) {
      return this.messages[this.messages.length-1].username == username;
    },
    async sendMessage(message) {
      axios("http://localhost:9000/message/", {
        method: "post",
        data: message,
        headers: {
          "Access-Control-Allow-Origin": "*",
          Accept: "application/json",
          "Content-Type": "application/json",
          crossDomain: true
        }
      }).then(function(response) {});
    }
  },
  computed: {
    ...mapState(["messages"])
  }
};
</script>

<style scoped>
.container {
  height: 450px !important;
  overflow-y: scroll;
}
/* width */
::-webkit-scrollbar {
  width: 5px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey;
  border-radius: 10px;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: #35bd00;
  border-radius: 10px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #2e9e01;
}
</style>
