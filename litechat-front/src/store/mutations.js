export default {
    addColorForUser(state, {username, color}) {
        state.colorsForUsers[username] = color
    },
    changeLogged(state, logged) {
        state.logged = logged
    },
    addMessage(state, message) {
        state.messages.push(message)
    },
    replaceMessage(state, {message, index}) {
        state.messages[index] = message;
    }
}