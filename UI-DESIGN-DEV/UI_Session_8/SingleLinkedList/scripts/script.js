class Node { 
    constructor(element) 
    { 
        this.element = element; 
        this.next = null;
    } 
} 

class LinkedList { 
    constructor() 
    { 
        this.head = null; 
        this.size = 0; 
    }    
} 

var linkedlist = new LinkedList();
function addNode() 
{ 
    var element = document.getElementById("input").value;
    var node = new Node(element); 
    var current; 
  
    if (linkedlist.head == null) 
        {
            linkedlist.head = node;
            document.getElementById("screen").innerHTML = element+" added!";
        }
    else { 
        current = linkedlist.head; 
        while (current.next) { 
            current = current.next; 
        } 
  
        current.next = node;
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
	    while (current != null) { 
		if (current.element === element) { 

		    if (prev == null) { 
			linkedlist.head = current.next; 
		    } else { 
			prev.next = current.next; 
		    } 
		    linkedlist.size--; 
		    document.getElementById('screen').innerText = current.element+" Deleted!"; 
		    return 1;
		} 
		prev = current; 
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
