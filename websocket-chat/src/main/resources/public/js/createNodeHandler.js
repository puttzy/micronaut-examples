
createNodeSocket.onmessage = function (msg) { addToTree(msg); };
createNodeSocket.onclose = function () {
    socketClosed();
};

//Send message if "Send" is clicked
id("addFactory_Button").addEventListener("click", function () {
    sendCreateMessage();
});


//Send a message if it's not empty, then clear the input field
function sendCreateMessage() {
    var message = createFactoryMessage(1);
    createNodeSocket.send(JSON.stringify(message));
}

//Update the chat-panel, and the list of connected users
function addToTree(msg) {
    var data = msg.data;
    if (isJson(data)){
        id("chat").innerHTML = id("chat").innerHTML + msg.data;
    } else {alert('create not json:' + msg.data)}
}


function createFactoryMessage(numberOfNodes){
    var json =  '{' +
        '  "id": "1",' +
        '  "name": "Sellers",' +
        '  "number": ' + numberOfNodes + ',' +
        '  "min": 148,' +
        '  "max": 536' +
        '}';

    return JSON.parse(json);
}




