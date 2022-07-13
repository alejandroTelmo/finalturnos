window.addEventListener('load',function(){

const formularioModificar=document.querySelector('#modificar');
formularioModificar.addEventListener('submit',function(e){
 e.preventDefault();

 const formData={
    id:document.querySelector('#idPaciente').value,
    nombre:document.querySelector('#nombrePaciente').value,
    apellido:document.querySelector('#apellidoPaciente').value,
    dni:document.querySelector('#dniPaciente').value,
    domicilio:{
        calle:document.querySelector('#callePaciente').value,
        numero:document.querySelector('#numeroPaciente').value,
        ciudad:document.querySelector('#ciudadPaciente').value,
        provincia:document.querySelector('#provinciaPaciente').value
    }
 }
    const id=document.querySelector('#idPaciente').value;
    const url='http://localhost:8080/pacientes'+"/"+id;

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
              const url ='http://localhost:8080/pacientes'+"/"+id;
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(function(response){
                    return response.json();
            } )
            .then(data=>{
            console.log(data)
                let paciente=data;
                document.querySelector('#idPaciente').value=paciente.id;
                document.querySelector('#nombrePaciente').value=paciente.nombre;
                document.querySelector('#apellidoPaciente').value=paciente.apellido;
                document.querySelector('#dniPaciente').value=paciente.dni;
                document.querySelector('#callePaciente').value=paciente.domicilio.calle;
                document.querySelector('#numeroPaciente').value=paciente.domicilio.numero;
                document.querySelector('#ciudadPaciente').value=paciente.domicilio.ciudad;
                document.querySelector('#provinciaPaciente').value=paciente.domicilio.provincia;
                document.querySelector('#formularioOculto').style.display='block';

            })
                .catch(error=>{
                alert("Error"+error);
                })
    }
      function resetUploadForm(){
                   document.querySelector('#idPaciente').value="";
                           document.querySelector('#nombrePaciente').value="";
                           document.querySelector('#apellidoPaciente').value="";
                           document.querySelector('#dniPaciente').value="";
                           document.querySelector('#callePaciente').value="";
                           document.querySelector('#numeroPaciente').value="";
                           document.querySelector('#ciudadPaciente').value="";
                           document.querySelector('#provinciaPaciente').value="";
                           document.querySelector('#formularioOculto').style.display='none';
                                 location. reload();
            }