function dataSend() {
    var data = {
        content : $('#input-title').val(),
        completed : false
    };

    $.ajax({
        type: 'POST',
        url: 'todo/api',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function() {
        //responseData();
        window.location.href='/';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
}

function deleteData(id) {
    console.log(id);
    $.ajax({
        type: 'DELETE',
        url: 'todo/api/'+id,
    }).done(function(data) {
        window.location.href='/';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
}

function update(data) {
    console.log(data);
    $.ajax({
            type: 'PUT',
            url: 'todo/api/'+id,
        }).done(function(data) {
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
}