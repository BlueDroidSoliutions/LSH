function buyTokens(csrfToken, pricePackageId) {
    $.post('./checkout', { _csrf: csrfToken, pricePackageId: pricePackageId })
        .always(function(response) {
            if (response.success) {
                window.open(response.redirectUrl, '_self');
            } else {
                alert(response.message);
            }
        });
}