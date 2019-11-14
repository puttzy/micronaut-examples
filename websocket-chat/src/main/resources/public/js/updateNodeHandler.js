
updateNodeSocket.onmessage = function (msg) { updateTree(msg); };

updateNodeSocket.onclose = function () {
    socketClosed();
};

//Send message if "Send" is clicked
id("updateFactory_Button").addEventListener("click", function () {
    sendUpdateMessage(id("message").value);
});

//Send message if enter is pressed in the input field
id("message").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) {
        Number.isInteger(e.target.value);

        sendUpdateMessage(e.target.value);
    }
});

//Send a message if it's not empty, then clear the input field
function sendUpdateMessage(message) {
    if (message !== "") {

        updateNodeSocket.send(JSON.stringify(updateNodeFactory(message)));
        id("message").value = "";
    }
}

//Update the chat-panel, and the list of connected users
function updateTree(msg) {
    if (isJson(msg.data)) {
        var response = JSON.parse(msg.data);
        id("chat").innerHTML = msg.data;
    } else (alert('update not json: ' + msg.data));
}



function updateNodeFactory(numberOfNodes){
    var json =  '{' +
        '  "id": "1",' +
        '  "name": "Sellers",' +
        '  "number": ' + numberOfNodes + ',' +
        '  "min": 148,' +
        '  "max": 536' +
        '}';

    return JSON.parse(json);
}


