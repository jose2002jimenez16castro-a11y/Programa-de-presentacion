const year = document.getElementById("year");
year.textContent = new Date().getFullYear();

const idea = document.getElementById("idea");
const salida = document.getElementById("salida");

document.getElementById("btnGenerar").addEventListener("click", () => {
  const text = idea.value.trim();
  if (!text) {
    salida.value = "Escribe una idea primero (ej: tu proyecto, habilidad o experiencia).";
    return;
  }

  salida.value =
`Resumen profesional:
${text}

Versión para CV:
• ${text}
• Tecnologías: HTML, CSS, JavaScript
• Enfoque: calidad, orden y entrega a tiempo

Versión para LinkedIn:
Estoy desarrollando ${text}. Estoy mejorando mis habilidades y construyendo proyectos reales.`;
});

document.getElementById("btnLimpiar").addEventListener("click", () => {
  idea.value = "";
  salida.value = "";
});

const form = document.getElementById("form");
const formMsg = document.getElementById("formMsg");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  formMsg.textContent = "Mensaje preparado (demo). Para envío real usa Netlify Forms o Formspree.";
});
