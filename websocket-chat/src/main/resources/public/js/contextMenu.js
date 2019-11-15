var factory_menu = {

};

var contex_menu = {
    'factoryMenu' : {
        elements : [
            {
                text : 'Delete Factory',
                icon: 'images/delete.png',
                action : function(node) {
                    node.removeNode();
                }
            },{
                text : 'Rename Factory',
                icon: 'images/delete.png',
                action : function(node) {
                    node.setText('dan');
                }
            }
        ]
    }
    /*'context1' : {
        elements : [
            {
                text : 'Node Actions',
                icon: 'images/blue_key.png',
                action : function(node) {

                },
                submenu: {
                    elements : [
                        {
                            text : 'Toggle Node',
                            icon: 'images/leaf.png',
                            action : function(node) {
                                node.toggleNode();
                            }
                        },
                        {
                            text : 'Expand Node',
                            icon: 'images/leaf.png',
                            action : function(node) {
                                node.expandNode();
                            }
                        },
                        {
                            text : 'Collapse Node',
                            icon: 'images/leaf.png',
                            action : function(node) {
                                node.collapseNode();
                            }
                        },
                        {
                            text : 'Expand Subtree',
                            icon: 'images/tree.png',
                            action : function(node) {
                                node.expandSubtree();
                            }
                        },
                        {
                            text : 'Collapse Subtree',
                            icon: 'images/tree.png',
                            action : function(node) {
                                node.collapseSubtree();
                            }
                        },
                        {
                            text : 'Delete Node',
                            icon: 'images/delete.png',
                            action : function(node) {
                                node.removeNode();
                            }
                        }
                    ]
                }
            },
            {
                text : 'Child Actions',
                icon: 'images/blue_key.png',
                action : function(node) {

                },
                submenu: {
                    elements : [
                        {
                            text : 'Create Child Node',
                            icon: 'images/add1.png',
                            action : function(node) {
                                node.createChildNode('Created',false,'images/folder.png',null,'context1');
                            }
                        },
                        {
                            text : 'Create 1000 Child Nodes',
                            icon: 'images/add1.png',
                            action : function(node) {
                                for (var i=0; i<1000; i++)
                                    node.createChildNode('Created -' + i,false,'images/folder.png',null,'context1');
                            }
                        },
                        {
                            text : 'Delete Child Nodes',
                            icon: 'images/delete.png',
                            action : function(node) {
                                node.removeChildNodes();
                            }
                        }
                    ]
                }
            }
        ]
    }*/
};


tree = createTree('div_tree','white',contex_menu);
tree.drawTree();
var l1 = tree.createNode('Level 1',false,'images/factory.jpeg',null,'parent1','factoryMenu');
var l2 = tree.createNode('Level 2',false,'images/factory.jpeg',null,'parent2','factoryMenu');
l1.createChildNode('Child1',false,'images/leaf.png','child1',null);
l2.createChildNode('Child 2',false,'images/leaf.png','child2',null);