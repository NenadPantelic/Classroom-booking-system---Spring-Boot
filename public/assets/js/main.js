$(document).ready(function() {

    $('.ui.sidebar').sidebar('attach events', '.toc.item');

    $('.coupled.modal')
        .modal({
            allowMultiple: false
        })
    ;
// attach events to buttons
    $('.second.modal') .modal('attach events', '.first.modal .button');
// show first now
    $('.first.modal').modal('show');
});
