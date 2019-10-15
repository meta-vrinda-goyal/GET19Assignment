class Node { 
    constructor(element) 
    { 
        this.element = element; 
        this.next = null;
        this.prev = null;
    } 
} 

class DoublyLinkedList { 
    constructor() 
    { 
        this.head = null; 
        this.tail = null;
        this.size = 0; 
    }    
} 

var linkedlist = new DoublyLinkedList();

function addNode() 
{ 
  var element = document.getElementById("input").value;
    let node = new Node(element); 
   if (linkedlist.head == null) 
        {
            linkedlist.head = node;
            linkedlist.tail = node;
            document.getElementById("screen").innerHTML = element+" added!";
        }
    else { 

        node.prev = linkedlist.tail;
        linkedlist.tail.next = node;
        linkedlist.tail = node;
        document.getElementById("screen").innerHTML = element+" added!"; 
    } 
    linkedlist.size++; 
} 

function deleteNode()
{
    var element = document.getElementById('input').value;
    if(linkedlist.head == null)
    {
        document.getElementById("screen").innerHTML ="Linkedlist is empty";
        return -1;
    }
    else
    {
        var current = linkedlist.head; 
        var prev = null; 
        while (current) {  

            if (current.element === element) { 

                if (current == linkedlist.head && current == linkedlist.tail) { 
                    linkedlist.head = null;
                    linkedlist.tail = null; 
                } else if(current == linkedlist.head) {
                    linkedlist.head = linkedlist.head.next;
                    linkedlist.tail = null;
                } else if(current == linkedlist.tail) {
                    linkedlist.tail = linkedlist.tail.prev;
                    linkedlist.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                linkedlist.size--; 
                document.getElementById('screen').innerText = current.element+" Deleted!"; 
                return 1;
            } 
            current = current.next; 
        } 
    document.getElementById('screen').innerText = "Element not found!";
    return -1;
    }

}

function displayNode()
{
    if(linkedlist.head == null)
    {
        document.getElementById("screen").innerText = "EMPTY LIST";
        return -1;
    }

    if(linkedlist.size == 1)
    {
        document.getElementById("screen").innerText = linkedlist.head.element;
        return 1;
    }
     var current = linkedlist.head;
     var array = [];
    
        do
        {
            array.push(current.element);
            current = current.next;
        }
        while(current.next);
        array.push(current.element);
        array.toString();
        document.getElementById("screen").innerText = array;
        return 1;
}
