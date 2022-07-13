window.addEventListener('load',function(){

const formularioModificar=document.querySelector('#modificarOdontologo');
formularioModificar.addEventListener('submit',function(e){

   e.preventDefault();

 const formData={
    id:document.querySelector('#idOdontologo').value,
    nombre:document.querySelector('#nombreOdontologo').value,
    apellido:document.querySelector('#apellidoOdontologo').value,
    numeroMatricula:document.querySelector('#numeroMatriculaOdontologo').value
 }
    const id=document.querySelector('#idOdontologo').value;
    const url='http://localhost:8080/odontologos'+"/"+id;

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
        resetUploadForm();
        })
})


})
function findById(id){
              const url ='http://localhost:8080/odontologos'+"/"+id;
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(function(response){
                    return response.json();
            } )
            .then(data=>{
            console.log(data)
                let odontologo=data;
                document.querySelector('#idOdontologo').value=odontologo.id;
                document.querySelector('#nombreOdontologo').value=odontologo.nombre;
                document.querySelector('#apellidoOdontologo').value=odontologo.apellido;
                document.querySelector('#numeroMatriculaOdontologo').value=odontologo.numeroMatricula;
                document.querySelector('#formularioOculto').style.display='block';

            })
                .catch(error=>{
                alert("Error"+error);
                })
    }
        function resetUploadForm(){
            document.querySelector('#idOdontologo').value="";
            document.querySelector('#nombreOdontologo').value="";
            document.querySelector('#apellidoOdontologo').value="";
            document.querySelector('#numeroMatriculaOdontologo').value="";
            document.querySelector('#formularioOculto').style.display='none';
            location. reload();
        }