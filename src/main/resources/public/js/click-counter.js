var clickCounterApi = Vue.resource('/lick-counter')

Vue.component('click-counter', {
    data: function () {
        return {
            click_counter: ''
        }
    },
    template:
        '<div>' +
        '<div> Количество нажатий:' +
        '</div>' +
        '<input type="text" readonly v-model="click_counter"/>' +
        '<input type="button" placeholder="click!" @click="update_counter"/>' +
        '</div>',
    created: function () {
        clickCounterApi.get().then(result =>
            this.click_counter = result.body
        )
    },
    methods: {
        update_counter: function () {
            clickCounterApi.save({}, null);
        }
    }

});


var clickCounter = new Vue({
    el: '#clickCounter',
    template: '<click-counter/>',
});