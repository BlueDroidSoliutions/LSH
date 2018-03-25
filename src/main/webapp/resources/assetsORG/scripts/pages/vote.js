function buyTokens(csrfToken, pricePackageId) {
    $.post('./checkout', { _csrf: csrfToken, pricePackageId: pricePackageId })
        .always(function(response) {
            if (response.success) {
                window.location = response.redirectUrl;
            } else {
				alert(response.message);
			}
        });
}
