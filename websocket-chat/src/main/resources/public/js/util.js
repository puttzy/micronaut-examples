function isJson(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        return false;
    }
    return true;
}

//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}

id("connection_status").addEventListener("click", function () {
    initConnections();
    id("connection_status").classList.replace('reddot', 'greendot' );
    loadNodeSocket.send(true);
});

function socketClosed(){
    id("connection_status").classList.replace('greendot', 'reddot' );
    id("chat").innerHTML = '';
    createNodeSocket.close();
    loadNodeSocket.close();
    updateNodeSocket.close();
}