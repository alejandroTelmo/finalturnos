window.addEventListener('load',function(){

    const formAlta=document.querySelector('#formularioAlta');

    formAlta.addEventListener('submit',function(e){
        e.preventDefault();

        const url='http://localhost:8080/turnos';
                const data={
                      odontologo : {"id": document.querySelector('#idOdontologo').value} ,
                      paciente : { "id":document.querySelector('#idPaciente').value} ,
                      horaturno : (document.querySelector('#horaturno').value).concat(":00"),
                      diaturno: document.querySelector('#diaturno').value
                      }
                const settings={
                    method:'POST',
                    headers:{
                    'Content-Type':'application/json'
                    },
                    body:JSON.stringify(data)
                }
                fetch(url,settings)
                .then(response=>response.json())
                .then(data=>{
                console.log(data)
                resetForm();
               } )
console.log(document.querySelector('#horaturno').value)
console.log({"id": document.querySelector('#idOdontologo').value})
console.log({ "id":document.querySelector('#idPaciente').value})
console.log(horaturno )
})


})
function resetForm(){
                        document.querySelector('#idOdontologo').value="";
                      document.querySelector('#idPaciente').value="";
                      document.querySelector('#horaturno').value="";
                      document.querySelector('#diaturno').value="";
                      lista();
                }
                    (function lista(){
                        const crear=document.querySelector("#altaTurno")
                        crear.addEventListener('click',()=>{
                            window.location.assign("turno_lista.html")
                        })

                     } )();