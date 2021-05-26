var stompClient = null;
var clickCounterApi = Vue.resource('/click-counter')

function connect() {
    var socket = new SockJS('/gs-guide-websocket')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, frame => {
        console.log('Connected: ' + frame)
        stompClient.subscribe('/topic/counter', sub_count => {
            clickCounter.click_counter = (JSON.parse(sub_count.body)).counter
        })
    })
}

function sendCounter(counter) {
    stompClient.send("/app/changeCounter", {}, JSON.stringify(counter))
}

var clickCounter = new Vue({
    el: '#clickCounter',
    data: function () {
        return {
            click_counter: ''
        }
    },
    template:
        '<div>' +
        '<div> Количество нажатий:' +
        '</div>' +
        '<div> {{ this.click_counter }}</div>' +
        '<div>' +
        '</div>' +
        '<input type="button" value="click" @click="update_counter"/>' +
        '</div>',
    created() {
        connect()
        clickCounterApi.get().then(result =>
            result.json().then(data => {
                    this.click_counter = data.counter
                }
            )
        )

    },
    methods: {
        update_counter: function () {
            sendCounter({id: 1});
            clickCounterApi.get().then(result =>
                result.json().then(data => {
                        this.click_counter = data.counter
                    }
                )
            )
        },
        increment_counter: function () {
            clickCounterApi.get().then(result =>
                result.json().then(data => {
                        this.click_counter = data.counter
                    }
                )
            )
        }
    }
});