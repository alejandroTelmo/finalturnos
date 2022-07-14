window.addEventListener('load',function(){

const formularioAltaOdontologo=document.querySelector("#formularioAlta");

formularioAltaOdontologo.addEventListener('submit',function(e){

    e.preventDefault();

    const formData={

        nombre:document.querySelector('#nombre').value,
        apellido:document.querySelector('#apellido').value,
        numeroMatricula:document.querySelector('#numeroMatricula').value
    }
    const url='http://localhost:8080/odontologos';

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
        '<strong>Odontologo guardado</strong> </div>'
        document.querySelector('#response').innerHtml=successAlert;
         document.querySelector('#response').style.display="block";
         resetUploadForm();
         lista();
        }

        )
        .catch(error=>{
             let errorAlert='<div class="alert alert-danger alert-dismissible">'+
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>'+
                    '<strong>Error intente nuevamente</strong> </div>'
                    document.querySelector('#response').innerHtml=errorAlert;
                     document.querySelector('#response').style.display="block";
                     resetUploadForm();
        })

})
    function resetUploadForm(){
        document.querySelector('#nombre').value="";
        document.querySelector('#apellido').value="";
        document.querySelector('#numeroMatricula').value="";
        lista();
            }
    (function lista(){
        const crear=document.querySelector("#crearOdontologo")
        crear.addEventListener('click',()=>{
            window.location.assign("odontologo_lista.html")
        })

     } )();


});