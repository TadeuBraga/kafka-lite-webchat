<template>
  <b-card align="left" class="mb-2">
    <b-card-sub-title>
      <h5 :style="{color: getUserColor(message.username)}">{{message.username}}</h5>
    </b-card-sub-title>
    <b-card-text v-once align="left">
      <div class="bg-light ml-2" v-text="message.content" />
    </b-card-text>

    <b-card-text v-once align="right">
      <small>{{ message.time | formatDate }}</small>
    </b-card-text>
  </b-card>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  props: {
    message: Object
  },
  data() {
    return {};
  },
  methods: {
    ...mapActions(["addColorForUser"]),
    getUserColor: function(username) {
      if (username != null) {
        if (this.colorsForUsers[username] != null) {
          return this.colorsForUsers[username];
        } else {
          const newColor = ((Math.random() * 0xffffff) << 0).toString(16);
          this.addColorForUser({ username, color: "#" + newColor });
          return this.colorsForUsers[username];
        }
      }
      return "#000000";
    }
  },
  computed: {
    ...mapState(["colorsForUsers"])
  }
};
</script>

<style scoped>
.card-body {
  padding: 7px;
}
.green {
  color: #35bd00;
}
</style>