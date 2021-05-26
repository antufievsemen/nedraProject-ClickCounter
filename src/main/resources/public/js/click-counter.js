var clickCounterApi = Vue.resource('/click-counter')

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
        '<input type="number" readonly v-model="click_counter"/>' +
        '<div>' +
        '</div>' +
        '<input type="button" value="click" @click="update_counter"/>' +
        '</div>',
    created: function () {
        clickCounterApi.get().then(result =>
            result.json().then(data =>
                this.click_counter = data.counter
            )
        )
    },
    methods: {
        update_counter: function () {
            clickCounterApi.save({}, null);
            clickCounterApi.get().then(result =>
                result.json().then(data =>
                    this.click_counter = data.counter
                )
            )
        }
    }

});


var clickCounter = new Vue({
    el: '#clickCounter',
    template: '<click-counter/>',
});