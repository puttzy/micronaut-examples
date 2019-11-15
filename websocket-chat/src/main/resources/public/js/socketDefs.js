var sessionId = uuidv4();

initConnections();

function initConnections(){
    createNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/create/create/" + sessionId);
    loadNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/load/load/" + sessionId );
    updateNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/update/update/" + sessionId );
}

function uuidv4() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}