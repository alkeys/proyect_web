$("#usuario").on('keypress', function () {
    var limit = 30;
    $("#usuario").attr('maxlength', limit);
    var init = $(this).val().length;

    if (init < limit) {
        init++;
        $('#caracteres').text("Máximo 30 caracteres: " + init);
    }

});

$("#password").on('keypress', function () {
    var limit = 20;
    $("#password").attr('maxlength', limit);
    var init = $(this).val().length;

    if (init < limit) {
        init++;
        $('#caracteres2').text("Máximo 20 caracteres: " + init);
    }

});

$('#password').keyup(function(e) {
    var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
    var enoughRegex = new RegExp("(?=.{6,}).*", "g");
    if (false == enoughRegex.test($(this).val())) {
            $('#passstrength').html('Más caracteres.');
    } else if (strongRegex.test($(this).val())) {
            $('#passstrength').className = 'ok';
            $('#passstrength').html('Fuerte!');
    } else if (mediumRegex.test($(this).val())) {
            $('#passstrength').className = 'alert';
            $('#passstrength').html('Media!');
    } else {
            $('#passstrength').className = 'error';
            $('#passstrength').html('Débil!');
    }
    return true;
});