let codeEditor = ace.edit("editorCode");
let textarea = $('textarea[name = "userSolution"]');
codeEditor.getSession().setValue(textarea.val());
codeEditor.getSession().on("change", function(){
  textarea.val(codeEditor.getSession().getValue());
  codeEditor.setValue(textarea)
})