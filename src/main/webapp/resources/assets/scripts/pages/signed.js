function buyVipMembership(csrfToken) {
    $.post('./checkout/vipMembership', { _csrf: csrfToken })
        .always(function(response) {
            if (response.success == false) {
                alert(response.message);
            }
        });
}
