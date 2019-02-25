<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Moduli disponibili</title>


    <#include "importCss.ftl">

    <!-- CSS DATATABLES -->
    <link href="../css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('../imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>MODULI</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Moduli Disponibili</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">MODULO PER LA CONVENZIONE</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="table-responsive mb-30">
                <table class="table table-bordered g-white text-center border">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Tipologia</th>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <th>Stampa Modulo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>CONVENZIONE PER LO SVOLGIMENTO DI ATTIVITA&apos; DI TIROCINIO E DI ORIENTAMENTO</td>
                        <td>CONVENZIONE</td>
                        <td>10/01/2018</td>
                        <td>11/01/2018</td>
                        <td><a href="modulo-convenzione-aziendale.html">
                            <button type="button" class="btn btn-outline-success"><i class="fa fa-print"></i>Stampa
                                Modulo
                            </button>
                        </a></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <h1 class="mb-0">MODULI TIROCINI SVOLTI</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <form id="form_tirocinii_fine" action="print.php" method="post">
                <table class="table table-responsive table-striped table-bordered bg-white table-hover border" id="datatable_2" width="100%"
                       cellspacing="0">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>E-mail</th>
                        <th>Stato Richiesta</th>
                        <th>Fine Tirocinio</th>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <th>Stampa Modulo</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>E-mail</th>
                        <th>Stato Richiesta</th>
                        <th>Fine Tirocinio</th>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <th>Stampa Modulo</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <tr>
                        <td>Tiger</td>
                        <td>Nixon</td>
                        <td>2011/04/25</td>
                        <td>Tirocinio in corso</td>
                        <td><input type="checkbox" class="checkboxes" name="fin_Tiger" value="1"/> <i
                                class="fa fa-check" style="color: green;"></i> Tirocinio finito
                        </td>
                        <td>N/D</td>
                        <td>N/D</td>
                        <td>
                            <button type="button" class="btn btn-outline-danger"><i class="fa fa-print"></i>Non
                                disponibile
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>Garrett</td>
                        <td>Winters</td>
                        <td>63</td>
                        <td>Concluso il 2011/07/25</td>
                        <td><input type="checkbox" class="checkboxes" name="fin_Garret" value="1" checked
                                   disabled/> <i
                                class="fa fa-check" style="color: green;"></i> Tirocinio finito
                        </td>
                        <td>10/01/2018</td>
                        <td>11/01/2018</td>
                        <td><a href="modulo-tirocinio-aziendale.html">
                            <button type="button" class="btn btn-outline-success"><i class="fa fa-print"></i>Stampa
                                Modulo
                            </button>
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>Ashton</td>
                        <td>Cox</td>
                        <td>66</td>
                        <td>Concluso il 2009/01/12</td>
                        <td><input type="checkbox" class="checkboxes" name="fin_Ashton" value="1" checked
                                   disabled/> <i
                                class="fa fa-check" style="color: green;"></i> Tirocinio finito
                        </td>
                        <td>10/01/2018</td>
                        <td>11/01/2018</td>
                        <td><a href="modulo-tirocinio-aziendale.html">
                            <button type="button" class="btn btn-outline-success"><i class="fa fa-print"></i>Stampa
                                Modulo
                            </button>
                        </a>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_tirocinii_fine"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                            class="fa fa-check"></i> Aggiorna
                    </button>
                    <button type="reset" form="form_tirocinii_fine"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                            class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>

    </section>

    <#include "footer.ftl">
</div>

<#include "importScript.ftl">

<!-- Script page -->
<script src="../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableAccettati() {

        var table = jQuery('#datatable_2');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }],
            "order": [
                [1, 'asc']
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Cerca: ",
                "searchPlaceholder": "Filtra i record",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    initTableAccettati();
</script>
</body>
</html>