
loadNodeSocket.onmessage = function (msg) { redrawData(msg); };
loadNodeSocket.onclose = function () {
        socketClosed();
};

//Send message if "Send" is clicked
id("load").addEventListener("click", function () {
    sendLoadMessage(id("message").value);
});

//Send message if enter is pressed in the input field
id("message").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) {
        Number.isInteger(e.target.value);

        sendLoadMessage(e.target.value);
    }
});

//Send a message if it's not empty, then clear the input field
function sendLoadMessage() {
    loadNodeSocket.send(true);
    id("message").value = "";
}

//Update the chat-panel, and the list of connected users
function redrawData(msg) {
    if (isJson(msg.data)) {
        id("chat").innerHTML =  msg.data;
    } else {alert('load - not json:' + msg.data)}
}

