window.addEventListener('load',function(){

const formularioModificar=document.querySelector('#modificar');
formularioModificar.addEventListener('submit',function(e){

 const formData={

    id  :document.querySelector('#idUsuario').value,
    username : document.querySelector('#username').value,
    password : document.querySelector('#password').value

 }
    const url='http://localhost:8080/usuarios';

    const settings={
    method:'PUT',
    headers:{
    'Content-Type':'application/json'
    },
    body: JSON.stringify(formData)
    }
    fetch(url,settings)
        .then(response=>response.json())
        .then( data=>{
        console.log(data)
        })
})


})
function findById(id){
              const url ='http://localhost:8080/usuarios'+"/"+id;
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(function(response){
                    return response.json();
            } )
            .then(data=>{
            console.log(data)
                let usuario=data;
                document.querySelector('#idUsuario').value=usuario.id;
                document.querySelector('#username').value=usuario.username;
                password:document.querySelector('#password').value=usuario.password;
                document.querySelector('#formularioOculto').style.display='block';

            })
                .catch(error=>{
                alert("Error"+error);
                })
    }