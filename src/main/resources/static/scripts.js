'use distinct'

$(document).ready(function () {

    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        let text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (User, status) {
                $('.myForm #id').val(user.id);
                $('.myForm #name').val(user.name);
                $('.myForm #lastName').val(user.lastName);
                $('.myForm #email').val(user.email);
                $('.myForm #role').val(user.role);
                $('.myForm #age').val(user.age);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #name').val('');
            $('.myForm #capital').val('');
            $('.myForm #exampleModal').modal();
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});