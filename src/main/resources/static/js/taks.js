// SEGURIDAD: Si no se encuentra en localStorage info del usuario
// no lo deja acceder a la página, redirigiendo al login inmediatamente.

// if (localStorage.getItem('jwt')!== null){
//   console.log('Esta logueado')
// }else {
//   console.log('No esta logueado')
//   location.replace('/ToD0_initial_-_04.2022_-_Delfi/index.html')
// }

//if (!localStorage.jwt){
  //console.log('No esta logueado');
  //location.replace('/turnos/static/index.html');
//}

/* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

  /* ---------------- variables globales y llamado a funciones ---------------- */
  const urlTasks = 'https://ctd-fe2-todo.herokuapp.com/v1/tasks';
  const urlUsers = 'https://ctd-fe2-todo.herokuapp.com/v1/users';
  const user =  document.querySelector('div p');
  const btnCerrarSesion =  document.querySelector('#closeApp');
  const input = document.getElementById('nuevaTarea');
  const formCrearTarea = document.forms[0];
  const pending = document.querySelector('ul.tareas-pendientes');
  const finished = document.querySelector('ul.tareas-terminadas');
  const token = JSON.parse(localStorage.jwt);
  const contador = document.getElementById('cantidad-finalizadas')

  //obtenerNombreUsuario()
 // consultarTareas()
  /* -------------------------------------------------------------------------- */
  /*                          FUNCIÓN 1 - Cerrar sesión                         */
  /* -------------------------------------------------------------------------- */

  btnCerrarSesion.addEventListener('click', function () {
    const logout = confirm('¿Desea cerrar sesión?');
    if(logout){
      localStorage.clear();
      location.replace('/turnos/static/index.html');
    }
  });

  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 2 - Obtener nombre de usuario [GET]                */
  /* -------------------------------------------------------------------------- */

  function obtenerNombreUsuario() {
    const settings = {
      method: 'GET',
      headers: {
        authorization: token
      }
    }

    fetch(`${urlUsers}/getMe`, settings)
    .then(response => {
      console.log(response)
      if(!response.ok){
        alert(`Hubo un error, intentelo de nuevo.`)
      }
      return response.json();
    })
    .then(data => {
      console.log('Promesa cumplida:')
      console.log(data)
      // localStorage.setItem('userName', `${data.firstName} ${data.lastName}`)
      user.innerHTML=`${data.firstName} ${data.lastName}`
    })
    .catch(error => {
      console.log('Promesa rechazada:')
      console.error(error)
    })


  };

  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 3 - Obtener listado de tareas [GET]                */
  /* -------------------------------------------------------------------------- */

  function consultarTareas() {
    const settings = {
      method: 'GET',
      headers: {
        authorization: token
      }
    }
    fetch(urlTasks, settings)
    .then(response => {
      console.log(response)
      if(!response.ok){
        alert(`Hubo un error, intentelo de nuevo.`)
      }
      return response.json();
    })
    .then(data => {
      console.log('Promesa cumplida:')
      console.log(data)
      renderizarTareas(data)
      botonesCambioEstado()
      botonBorrarTarea()
    })
    .catch(error => {
      console.log('Promesa rechazada:')
      console.error(error)
    })



  };

  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 4 - Crear nueva tarea [POST]                    */
  /* -------------------------------------------------------------------------- */

  formCrearTarea.addEventListener('submit', function (event) {
    event.preventDefault();
    console.log('creando tarea:');
    console.log(input.value);

    let body = {
      description: input.value.trim(),
      completed: false
    }
    const settings = {
      method: 'POST',
      body: JSON.stringify(body),
      headers: {
        'Content-Type': 'application/json',
        authorization: token
      }
    }
    fetch(urlTasks, settings)
    .then(response => {
      console.log(response)
      if(!response.ok){
        alert(`Hubo un error, intentelo de nuevo.`)
      }
      return response.json();
    })
    .then(data => {
      console.log('Promesa cumplida:')
      console.log(data)
      consultarTareas()
    })
    .catch(error => {
      console.log('Promesa rechazada:')
      console.error(error)
    })

    formCrearTarea.reset();




  });

  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 5 - Renderizar tareas en pantalla                 */
  /* -------------------------------------------------------------------------- */
  function renderizarTareas(listado) {
    let incompletas = listado.filter(e => !e.completed)
    let completas = listado.filter(e => e.completed)
    pending.innerHTML=''
    finished.innerHTML=''
    let contando = 0;

    for (let tarea of incompletas) {
      let fecha = new Date(tarea.createdAt);

      pending.innerHTML+= `
      <li class="tarea">
        <button class="change" id="${tarea.id}"><i class="fa-regular fa-circle"></i></button>
        <div class="descripcion">
          <p class="nombre">${tarea.description}</p>
          <p class="timestamp">${fecha.toLocaleDateString()}</p>
        </div>
      </li>
      `
    }


    for (let tarea of completas) {

      finished.innerHTML+= `
      <li class="tarea">
        <div class="hecha">
          <i class="fa-regular fa-circle-check"></i>
        </div>
        <div class="descripcion">
          <p class="nombre">${tarea.description}</p>
          <div class="cambios-estados">
            <button class="change incompleta" id="${tarea.id}" ><i class="fa-solid fa-rotate-left"></i></button>
            <button class="borrar" id="${tarea.id}"><i class="fa-regular fa-trash-can"></i></button>
          </div>
        </div>
      </li>
      `
      contando++
    }

    contador.innerHTML = contando

  };

  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 6 - Cambiar estado de tarea [PUT]                 */
  /* -------------------------------------------------------------------------- */
  function botonesCambioEstado() {
    const botonesCambio = document.querySelectorAll('.change');

    botonesCambio.forEach(boton=>{
      boton.addEventListener('click', (e)=>{
        console.log("Cambiando estado de tarea...");
        console.log(e);

        let id = e.target.id;
        let url= `${urlTasks}/${id}`
        let body ={}

        if(e.target.classList.contains('incompleta')){
          body={
            completed:false
          }
        }else{
          body={
            completed:true
          }
        }

        const settings = {
          method: 'PUT',
          body: JSON.stringify(body),
          headers: {
            'Content-Type': 'application/json',
            authorization: token
          }
        }
        fetch(url, settings)
        .then(response => {
          console.log(response)
          if(!response.ok){
            alert(`Hubo un error, intentelo de nuevo.`)
          }
          return response.json();
        })
        .then(data => {
          console.log('Promesa cumplida:')
          console.log(data)
          consultarTareas()
        })
        .catch(error => {
          console.log('Promesa rechazada:')
          console.error(error)
        })
      } )
    })


  }


  /* -------------------------------------------------------------------------- */
  /*                     FUNCIÓN 7 - Eliminar tarea [DELETE]                    */
  /* -------------------------------------------------------------------------- */
  function botonBorrarTarea() {

    let btnBorrar = document.querySelectorAll('.borrar');

    btnBorrar.forEach(boton =>{
      boton.addEventListener('click', (e)=>{

        let id = e.target.id;
        let url = `${urlTasks}/${id}`

        const settings = {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json',
            authorization: token
          }
        }
        fetch(url, settings)
        .then(response => {
          console.log('Borrado de tarea:')
          console.log(response.status)
          consultarTareas()
        })
        .catch(error => {
          console.log('Promesa rechazada:')
          console.error(error)
        })
      })
    })


  };

});