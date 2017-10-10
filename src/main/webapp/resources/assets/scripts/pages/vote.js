function buyTokens(csrfToken, pricePackageId) {
<<<<<<< HEAD
    $.post('/checkout', { _csrf: csrfToken, pricePackageId: pricePackageId })
        .always(function(response) {
            if (response.success == false) {
                alert(response.message);
            }
        });
}
=======
    $.post('./checkout', { _csrf: csrfToken, pricePackageId: pricePackageId })
        .always(function(response) {
            if (response.success) {
                window.open(response.redirectUrl, '_self');
            } else {
                alert(response.message);
            }
        });
}
>>>>>>> branch 'master' of https://roller01285@bitbucket.org/roller01285/www.livesexhouse.com.git
