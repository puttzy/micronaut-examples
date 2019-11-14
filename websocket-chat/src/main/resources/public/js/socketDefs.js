

var createNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/create/create" );
var loadNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/load/load" );
var updateNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/update/update" );

function initConnections(){
    createNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/create/create" );
    loadNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/load/load" );
    updateNodeSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/update/update" );
}