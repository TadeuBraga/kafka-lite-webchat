<template>
  <div>
    <b-input-group class="mt-3" v-if="!logged">
      <b-form-input
        placeholder="Username"
        v-model="message.username"
        @keyup.enter="handleAccessClick"
      ></b-form-input>
      <b-input-group-append>
        <b-button
          variant="outline-success"
          @click="handleAccessClick"
          :disabled="!message.username"
        >Acessar</b-button>
      </b-input-group-append>
    </b-input-group>
    <b-input-group class="mt-3" v-else>
      <b-form-input placeholder="Message" v-model="message.content" @keyup.enter="handleClick"></b-form-input>
      <b-input-group-append>
        <b-button variant="outline-success" @click="handleClick">> Enviar</b-button>
      </b-input-group-append>
    </b-input-group>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  data() {
    return {
      message: {
        username: "",
        content: ""
      }
    };
  },
  methods: {
    ...mapActions(["changeLogged"]),
    handleAccessClick() {
      this.changeLogged(true);
    },
    handleClick() {
      const messageToBeSent = Object.assign({}, this.message);
      this.sendMessage(messageToBeSent);
      this.message.content = "";
    }
  },
  computed: {
    ...mapState(["logged"])
  },
  props: {
    sendMessage: Function
  }
};
</script>