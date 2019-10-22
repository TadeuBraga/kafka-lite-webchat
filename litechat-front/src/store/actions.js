export default {
    addColorForUser: ({ commit }, payload) => {
        commit('addColorForUser', payload);
    },
    changeLogged: ({ commit }, payload) => {
        commit('changeLogged', payload);
    },
    addMessage: ({ commit }, payload) => {
        commit('addMessage', payload);
    },
    replaceMessage: ({ commit }, payload) => {
        commit('replaceMessage', payload);
    }
}