let stompClient = null;

function connect() {
    let socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        console.log("Connected");
    });
}

function subscribe() {
    let sender = document.getElementById("sender").value;

    stompClient.subscribe('/topic/chat/' + sender, function (msg) {
        showMessage(JSON.parse(msg.body));
    });
}

function sendMessage() {
    let sender = document.getElementById("sender").value;
    let receiver = document.getElementById("receiver").value;
    let content = document.getElementById("message").value;

    stompClient.send("/app/chat.send", {}, JSON.stringify({
        senderId: sender,
        receiverId: receiver,
        content: content
    }));

    document.getElementById("message").value = "";
}

function showMessage(msg) {
    let box = document.getElementById("chatBox");
    box.innerHTML += `<p><b>${msg.senderId}:</b> ${msg.content}</p>`;
}

connect();
