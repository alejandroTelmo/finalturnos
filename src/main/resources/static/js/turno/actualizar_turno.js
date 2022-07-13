window.addEventListener('load',function(){

const formularioModificar=document.querySelector('#modificar');
formularioModificar.addEventListener('submit',function(e){

    e.preventDefault();

 const formData={

    id  :document.querySelector('#idTurno').value,
    horaturno:(document.querySelector('#horaturno').value),
    diaturno: document.querySelector('#diaturno').value,
    paciente:{"id":turno.paciente.id     },
    odontologo:{"id":turno.odontologo.id},
 }
    const id=document.querySelector('#idTurno').value;
    const url='http://localhost:8080/turnos'+"/"+id;

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
              const url ='http://localhost:8080/turnos'+"/"+id;
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(function(response){
                    return response.json();
            } )
            .then(data=>{
            console.log(data)
                let turno=data;
                document.querySelector('#idTurno').value=turno.id;
                document.querySelector('#nombrePaciente').value=turno.paciente.nombre;
                document.querySelector('#apellidoPaciente').value=turno.paciente.apellido;
                document.querySelector('#nombreOdontologo').value=turno.odontologo.nombre;
                document.querySelector('#apellidoOdontologo').value=turno.odontologo.apellido;
                document.querySelector('#horaturno').value=turno.horaturno;
                document.querySelector('#diaturno').value=turno.diaturno;
                document.querySelector('#formularioOculto').style.display='block';

            })
                .catch(error=>{
                alert("Error"+error);
                })
    }
          function resetUploadForm(){
                       document.querySelector('#idTurno').value="";
                               document.querySelector('#nombrePaciente').value="";
                               document.querySelector('#apellidoPaciente').value="";
                               document.querySelector('#nombreOdontologo').value="";
                               document.querySelector('#apellidoOdontologo').value="";
                               document.querySelector('#horaturno').value="";
                               document.querySelector('#diaturno').value="";

                               document.querySelector('#formularioOculto').style.display='none';
                                     location. reload();
                }