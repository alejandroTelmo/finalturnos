window.addEventListener('load',function(){

const formularioAltaPaciente=document.querySelector("#formularioAlta");

formularioAltaPaciente.addEventListener('submit',function(e){

    e.preventDefault();


    const formData={

        nombre:document.querySelector('#nombre').value,
        apellido:document.querySelector('#apellido').value,
        dni:document.querySelector('#dni').value,
       domicilio:{
                        calle:document.querySelector('#nombreDeLaCalle').value,
                       numero:document.querySelector('#numero').value,
                       ciudad:document.querySelector('#ciudad').value,
                       provincia:document.querySelector('#provincia').value
       }

    }

    const url='http://localhost:8080/pacientes';

    const settings={
    method:'POST',
    headers:{
    'Content-Type':'application/json'
    },
    body: JSON.stringify(formData)
    }
    fetch(url,settings)
        .then(response=>response.json())
        .then( data=>{
        console.log(data)
        let successAlert='<div class="alert alert-success alert-dismissible">'+
        '<button type="button" class="close" data-dismiss="alert">&times;</button>'+
        '<strong>Paciente guardado</strong> </div>';

            document.querySelector('div#response').innerHtml+= successAlert ;
            document.querySelector('div#response').style.display="block";
            alert("Paciente guardado con exito")
         resetUploadForm();
        }

        )
        .catch(error=>{
             let errorAlert='<div class="alert alert-danger alert-dismissible">'+
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>'+
                    '<strong>Error intente nuevamente</strong> </div>'
                    document.querySelector('div#response').innerHtml=errorAlert;
                     document.querySelector('div#response').style.display="block";
                     resetUploadForm();
        })

})
    function resetUploadForm(){
        document.querySelector('#nombre').value="";
        document.querySelector('#apellido').value="";
        document.querySelector('#dni').value="";
        document.querySelector('#nombreDeLaCalle').value="";
        document.querySelector('#numero').value="";
        document.querySelector('#ciudad').value="";
        document.querySelector('#provincia').value="";
            lista();

    }
    (function lista(){
        const crear=document.querySelector("#altaPaciente")
        crear.addEventListener('click',()=>{
            window.location.assign("paciente_lista.html")
        })

     } )();


});