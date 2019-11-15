
updateNodeSocket.onmessage = function (msg) { updateNode(msg); };

updateNodeSocket.onclose = function () {
    socketClosed();
};

//Send message if "Send" is clicked
id("updateFactory_Button").addEventListener("click", function () {
    sendUpdateMessage();
});

//Send a message if it's not empty, then clear the input field
function sendUpdateMessage() {
    var updateMessage = new updateFactoryRequest();
    alert(JSON.stringify(updateMessage));
    updateNodeSocket.send(JSON.stringify(updateMessage));


}

//Update the node specific node
function updateNode(msg) {
    if (isJson(msg.data)) {

        var factory = JSON.parse(msg.data)[0];
        var parentNode = tree.findNode(factory.id);
        parentNode.setText(factory.name);
        parentNode.removeChildNodes();
        addNodes(parentNode, factory.nodes);

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



function isUpdateValid() {
    var nodeId = id("updateFactory_Id").value.trim();
    var name = id("updateFactory_Name").value.trim();
    var numNodes = id("updateFactory_Nodes").value.trim();
    var min = id("updateFactory_Min").value.trim();
    var max = id("updateFactory_Max").value.trim();

    id("updateFactory_Name").value = name.trim();

    console.log(nodeId);

    var isUpdateValid = true;

    if (isBlank(name, 'Factory Name')){
        isUpdateValid = false;
    }

    if (! isInt(numNodes)){
        alert('factory Nodes must be a number INT between 1 and 15 (inclusive)');
        isUpdateValid = false;
    } else if (numNodes  < 1 || numNodes > 15) {
        alert('factory Nodes must be a number INT between 1 and 15 (inclusive)');
        isUpdateValid = false;
    }

    if (! isInt(min)) {
        alert('Minimum range must be an integer less than max range');
        min = '';
        isUpdateValid = false;
    }

    if (! isInt(max)) {
        alert('Maximum range must be an integer greater than max range');
        max = '';
        isUpdateValid = false;
    }

    if (max <= min) {
        alert('Minimum range must be less than maximum range');
        isUpdateValid = false;
    }

    return isUpdateValid;
}

function updateFactoryRequest() {

    if (isUpdateValid()) {
        this.nodeId = id("updateFactory_Id").value;
        this.name = id("updateFactory_Name").value;
        this.number = id("updateFactory_Nodes").value;
        this.min = id("updateFactory_Min").value;
        this.max = id("updateFactory_Max").value;

        id("updateFactory_Id").value = '';
        id("updateFactory_Name").value = '';
        id("updateFactory_Nodes").value = '';
        id("updateFactory_Min").value = '';
        id("updateFactory_Max").value = '';
    } else {
        throw "Invalid input";
    }


}

