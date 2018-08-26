<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista Convenzioni</title>

    <!-- mobile settings -->
    <#include "importCss.ftl">

</head>
<body class="smoothscroll enable-animation">

<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/templates/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>LISTA CONVENZIONI </h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Lista Convenzioni</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container">
            <h2 class="fw-100">Aziende convenzionate per stage e tirocini</h2>

            <div class="row">
                <!-- Pagination -->
                <ul class="pagination col-12 col-md-5 col-lg-4 col-xl-3 mt-5 pl-15">
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">Tutto</a></li>
                </ul>
                <form id="querystring" class="col-12 col-md-7 col-lg-7 col-xl-9 pr-0 mb-0" method="get" action="print.php">
                    <fieldset class="mb-0">
                        <div class="row justify-content-xl-end pl-15 pr-15">
                            <div class="row col-sm-auto">
                                <h4 class="mt-9">Risultati: </h4>
                                <label class="col-8">
                                    <!-- select -->
                                    <div class="fancy-form fancy-form-select">
                                        <select class="form-control mr-15">
                                            <option value="25">25 per pagina &nbsp;</option>
                                            <option value="50">50 per pagina &nbsp;</option>
                                            <option value="100">100 per pagina &nbsp;</option>
                                        </select>
                                    </div>
                                </label>
                            </div>
                            <div class="row col-12 col-lg-7 col-xl-4">
                                <h4 class="mt-9">Localit&agrave;: </h4>
                                <label class="col-8">
                                    <!-- select -->
                                    <div class="fancy-form fancy-form-select">
                                        <select class="form-control mr-15">
                                            <option value="AQ">L&apos;Aquila</option>
                                            <option value="RM">Roma</option>
                                            <option value="PE">Pescara</option>
                                        </select>
                                    </div>
                                </label>
                            </div>
                            <div class="input-group col-11  col-4 col-md-11 col-lg-11 col-xl-4 mb-15">
                                <input type="text" class="form-control" aria-label=""
                                       placeholder="Cerca nella tabella" name="search">
                                <span class="input-group-btn">
                                            <button class="btn btn-primary material-ico" type="submit">
                                                <i class="material-icons">search</i>
                                            </button>
                                        </span>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>


            <div class="table-responsive">
                <table class="table table-bordered nomargin box-white">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Localit&agrave;</th>
                        <th>Web</th>
                        <th>Data Convenzione</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="4" class="alfabeto">A</td>
                    </tr>


                    <#list ListaConv as ListaConvenzione>

                    <tr>
                        <td>${ListaConvenzione.ragioneSociale}</td>
                        <td>${ListaConvenzione.indirizzoSedeLegale}</td>
                        <td><a href="${ListaConvenzione.link}">${ListaConvenzione.ragioneSociale}</a></td>
                        <td>${ListaConvenzione.dataConvenzione}</td>
                    </tr>

                    </#list>


                    <tr>
                        <td>Amazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>Amazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>Amazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">B</td>
                    </tr>

                    <tr>
                        <td>BAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>BAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>BAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">C</td>
                    </tr>

                    <tr>
                        <td>CAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.h</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>CAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.h</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>CAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.h</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">D</td>
                    </tr>

                    <tr>
                        <td>DAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.d</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>DAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.d</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>DAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.d</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">E</td>
                    </tr>

                    <tr>
                        <td>EAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.nope</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>EAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.nope</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>EAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.nope</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">F</td>
                    </tr>

                    <tr>
                        <td>FAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.de</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>FAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.de</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>FAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.de</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">G</td>
                    </tr>

                    <tr>
                        <td>GAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.com</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>GAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.com</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>GAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.com</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="alfabeto">H</td>
                    </tr>

                    <tr>
                        <td>HAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.it</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>HAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon.it</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    <tr>
                        <td>HAmazon</td>
                        <td>Roma</td>
                        <td><a href="http://amazon.it">Amazon</a></td>
                        <td>01/01/2000</td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <!-- Pagination -->
            <ul class="pagination ">
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Tutto</a></li>
            </ul>

        </div>
    </section>

    <!-- /FOOTER-->
    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script>
    $(document).ready(function(){
        $("form").submit(function (event) {
            if (searching($( "input[name='search']" ).val().toUpperCase())){
                event.preventDefault();
            }
        });

        function searching(search) {
            let objtr = $("tr");
            let obj;
            let bol = false;
            let count = 0;

            $.each(objtr, function (i, val) {
                obj = $(val).children("td").not("td.alfabeto");

                $.each(obj, function (i, val2) {
                    if ($(val2).text().toUpperCase() === search){
                        console.log("val2");
                        console.log(val2);
                        bol = false;
                        ++count;
                        return false;
                    } else {
                        console.log("NOPE");
                        bol = true;
                    }
                });

                if (bol){
                    $(obj).addClass("d-none");
                    console.log(val);
                }else {
                    $(obj).removeClass("d-none");
                }

            });

            if (count === 0){
                console.log(count);
                return false;
            }else {
                console.log(count);
                return true;
            }
        }

    });
</script>
</body>
</html>