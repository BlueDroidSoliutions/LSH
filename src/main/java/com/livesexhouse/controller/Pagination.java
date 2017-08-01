package com.livesexhouse.controller;

public class Pagination {

    public String pagination(int firstResult, int numOfProducts, String kategorija, int brProizPoStr, String pth) {
        String s = "";
        int paramStart = firstResult;
        int brojProizvodaUkupno = numOfProducts;

        int brojStranicaUkupno = (int) Math.ceil((double) brojProizvodaUkupno / (double) brProizPoStr);

        int stranicaTrenutna = (int) ((paramStart / brProizPoStr) + 1);

        if (paramStart > 0) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + "1="
                    + (paramStart - brProizPoStr) + "\">"
                    + "<li><i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i></li></a>";
        }

        if (stranicaTrenutna > 3 && brojStranicaUkupno > 5) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + "1=0"
                    + "\"><li>1</li></a> ";
        }

        if (brojStranicaUkupno > 5 && stranicaTrenutna > 3) {
            s = s + "<li>...</li>";
        }

        if (brojStranicaUkupno < 6) {
            for (int i = 1; i < brojStranicaUkupno + 1; i++) {
                if (i == stranicaTrenutna) {
                    s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                            + "1="
                            + ((i * brProizPoStr) - brProizPoStr)
                            + "\"class=\"active\"><li>" + i + "</li> </a>";
                } else {
                    s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                            + "1="
                            + ((i * brProizPoStr) - brProizPoStr)
                            + "\"><li>" + i + "</li></a> ";
                }
            }
        } else {
            if (stranicaTrenutna < 4) {
                for (int i = 1; i < 5; i++) {
                    if (i == stranicaTrenutna) {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\" class=\"active\"><li >" + i + "</li> </a>";
                    } else {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\"><li>" + i + "</li> </a>";
                    }
                }
            }

            if (stranicaTrenutna > 3 && stranicaTrenutna < brojStranicaUkupno - 2) {
                for (int i = stranicaTrenutna - 1; i < stranicaTrenutna + 2; i++) {
                    if (i == stranicaTrenutna) {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\" class=\"active\"><li >" + i + "</li> </a>";
                    } else {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\"><li>" + i + "</li> </a>";
                    }
                }
            }

            if (stranicaTrenutna > brojStranicaUkupno - 3) {
                if (stranicaTrenutna == brojStranicaUkupno) {
                    for (int i = stranicaTrenutna - 3; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"> <li>" + i + "</li> </a>";
                        }
                    }
                } else if (stranicaTrenutna == brojStranicaUkupno - 1) {
                    for (int i = stranicaTrenutna - 2; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + " <a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"><li>" + i + "</li> </a>";
                        }
                    }
                } else {
                    for (int i = stranicaTrenutna - 1; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + " <a href=\"" + pth + "./" + kategorija + "?"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"><li>" + i + "</li> </a>";
                        }
                    }
                }
            }
        }

        if (brojStranicaUkupno > 5 && stranicaTrenutna < brojStranicaUkupno - 2) {
            s = s + "<li>...</li>";
        }

        if (stranicaTrenutna < brojStranicaUkupno - 2 && brojStranicaUkupno > 5) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + "1="
                    + (brProizPoStr * brojStranicaUkupno - 1)
                    + "\"><li>" + brojStranicaUkupno + "</li></a> ";
        }

        if (stranicaTrenutna < brojStranicaUkupno) {

            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + "1="
                    + (paramStart + brProizPoStr) + "\">"
                    + "<li><i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i></li></a>";
        }
        return s;
    }

    public String pagination(int firstResult, int numOfProducts, String kategorija, int brProizPoStr, String pth, String allParameter) {
        String s = "";
        int paramStart = firstResult;
        int brojProizvodaUkupno = numOfProducts;

        int brojStranicaUkupno = (int) Math.ceil((double) brojProizvodaUkupno / (double) brProizPoStr);

        int stranicaTrenutna = (int) ((paramStart / brProizPoStr) + 1);

        if (paramStart > 0) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + allParameter + "&&"
                    + "1="
                    + (paramStart - brProizPoStr) + "\">"
                    + "<li><i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i></li></a>";
        }

        if (stranicaTrenutna > 3 && brojStranicaUkupno > 5) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + allParameter + "&&"
                    + "1=0"
                    + "\"><li>1</li></a> ";
        }

        if (brojStranicaUkupno > 5 && stranicaTrenutna > 3) {
            s = s + "...";
        }

        if (brojStranicaUkupno < 6) {
            for (int i = 1; i < brojStranicaUkupno + 1; i++) {
                if (i == stranicaTrenutna) {
                    s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                            + allParameter + "&&"
                            + "1="
                            + ((i * brProizPoStr) - brProizPoStr)
                            + "\"class=\"active\"><li>" + i + "</li> </a>";
                } else {
                    s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                            +  allParameter + "&&"
                            + "1="
                            + ((i * brProizPoStr) - brProizPoStr)
                            + "\"><li>" + i + "</li></a> ";
                }
            }
        } else {
            if (stranicaTrenutna < 4) {
                for (int i = 1; i < 5; i++) {
                    if (i == stranicaTrenutna) {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                +allParameter+ "&&"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\" class=\"active\"><li >" + i + "</li> </a>";
                    } else {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + allParameter + "&&"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\"><li>" + i + "</li> </a>";
                    }
                }
            }

            if (stranicaTrenutna > 3 && stranicaTrenutna < brojStranicaUkupno - 2) {
                for (int i = stranicaTrenutna - 1; i < stranicaTrenutna + 2; i++) {
                    if (i == stranicaTrenutna) {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + allParameter+ "&&"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\" class=\"active\"><li >" + i + "</li> </a>";
                    } else {
                        s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                + allParameter + "&&"
                                + "1="
                                + ((i * brProizPoStr) - brProizPoStr)
                                + "\"><li>" + i + "</li> </a>";
                    }
                }
            }

            if (stranicaTrenutna > brojStranicaUkupno - 3) {
                if (stranicaTrenutna == brojStranicaUkupno) {
                    for (int i = stranicaTrenutna - 3; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                     + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"> <li>" + i + "</li> </a>";
                        }
                    }
                } else if (stranicaTrenutna == brojStranicaUkupno - 1) {
                    for (int i = stranicaTrenutna - 2; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + " <a href=\"" + pth + "./" + kategorija + "?"
                                     + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"><li>" + i + "</li> </a>";
                        }
                    }
                } else {
                    for (int i = stranicaTrenutna - 1; i < brojStranicaUkupno + 1; i++) {
                        if (i == stranicaTrenutna) {
                            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                                    + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\" class=\"active\"><li>" + i + "</li> </a>";
                        } else {
                            s = s + " <a href=\"" + pth + "./" + kategorija + "?"
                                     + allParameter + "&&"
                                    + "1="
                                    + ((i * brProizPoStr) - brProizPoStr)
                                    + "\"><li>" + i + "</li> </a>";
                        }
                    }
                }
            }
        }

        if (brojStranicaUkupno > 5 && stranicaTrenutna < brojStranicaUkupno - 2) {
            s = s + "...";
        }

        if (stranicaTrenutna < brojStranicaUkupno - 2 && brojStranicaUkupno > 5) {
            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + allParameter + "&&"
                    + "1="
                    + (brProizPoStr * brojStranicaUkupno - 1)
                    + "\"><li>" + brojStranicaUkupno + "</li></a> ";
        }

        if (stranicaTrenutna < brojStranicaUkupno) {

            s = s + "<a href=\"" + pth + "./" + kategorija + "?"
                    + allParameter + "&&"
                    + "1="
                    + (paramStart + brProizPoStr) + "\">"
                    + "<li><i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i></li></a>";
        }
        return s;
    }

}
