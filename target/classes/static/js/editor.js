let codeEditor = ace.edit("editorCode");
let textarea = document.getElementById("userSolution");
codeEditor.getSession().setMode("ace/mode/javascript");
codeEditor.getSession().on("change", function(){
textarea.value = codeEditor.getSession().getValue();
})