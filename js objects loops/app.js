/*const numbers = [12,3,4,5];
console.log(numbers);
function greet(firstname){

  return 'hello'+''+ firstname;
}

console.log(greet('john'));
//immediatly invokable functionexpressions 
(function(name){
  console.log('hello'+name);
}
)('brad');
//when a function is put inside a object{} its called method

const todo={
  add: function(){
    console.log('add to do');
},
edit: function(id){
  console.log('edit to do'+id);
}
}
// defining functions outsie oibjects

todo.delete =function(){
  console.log('todo to delete');
}
todo.add();
todo.edit(55);
todo.delete();

for(let i=0; i<10; i++){
  if(i===2){
    console.log('2 is my favorite no');
    continue;//stop iterating
  }
  if(i===5){
    console.log('stop the loop');
    break;// stop the whole loop
  }
  console.log('number'+i);
}

//while loop
let i=0;
while(i<10){
  console.log('number '+i)
  i++
}

// do while 
let i=100;

do{
  console.log(''+i);
  i++
}
while(i<10)
const cars =['ford','chevy','honda','toyota'];
cars.forEach(function(index,index,array){
  console.log(`${index}:  ${car}`);
  console.log(array);
})
*/

const Name ='john';
const age= 30;
const city= 'miami';
let html;
// with template strings 
html =`
<ul>
  <li>name:${Name}</li>
  <li>age:${age}</li>
  <li>city:${city}</li>
  
</ul>
`;
document.body.innerHTML=html;