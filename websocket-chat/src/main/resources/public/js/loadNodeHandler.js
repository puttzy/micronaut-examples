
loadNodeSocket.onmessage = function (msg) { redrawData(msg); };
loadNodeSocket.onclose = function () {
        socketClosed();
};


//Send a message if it's not empty, then clear the input field
function sendLoadMessage() {
    loadNodeSocket.send(true);
}

//Update the chat-panel, and the list of connected users
function redrawData(msg) {
    var allData = msg.data;
    if (isJson(allData)) {
        addFactories(allData);

        //id("chat").innerHTML =  msg.data;
    } else {alert('load - not json:' + msg.data)}
}

