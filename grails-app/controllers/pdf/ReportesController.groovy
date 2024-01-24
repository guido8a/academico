package pdf

import jxl.WorkbookSettings
import jxl.write.Label
import jxl.write.WritableCellFormat
import jxl.write.WritableFont
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook
import org.apache.poi.hssf.usermodel.HSSFClientAnchor
import org.apache.poi.hssf.usermodel.HSSFPatriarch
import org.apache.poi.hssf.usermodel.HSSFSimpleShape
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import tutor.Asignatura
import tutor.Curso
import tutor.Dicta
import tutor.Gestion
import tutor.Horario
import tutor.Nivel
import tutor.Paralelo
import tutor.Periodo
import tutor.Profesor


class ReportesController {

    def dbConnectionService

    def reportes(){

    }


    def circulo () {

//        Workbook wb = new HSSFWorkbook()
//        OutputStream os = new FileOutputStream("Javatpoint.xls")
//        Sheet sheet = wb.createSheet("Sheet");
//        Row row = sheet.createRow(4); // Creating a row
//        Cell cell = row.createCell(1); // Creating a cell
//        HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
//        HSSFClientAnchor  a = new HSSFClientAnchor( 0, 0, 1023, 255, (short) 1, 0, (short) 1, 0 );
//        HSSFSimpleShape shape = patriarch.createSimpleShape(a);
//        shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
//                wb.write(os);



        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data Validation");
        HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
        HSSFClientAnchor a = new HSSFClientAnchor( 0, 0, 1023, 255, (short) 1, 0, (short) 2, 1 );
        HSSFSimpleShape shape1 = patriarch.createSimpleShape(a);
        shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
        shape1.setLineStyleColor(10,10,10);
        shape1.setFillColor(90,10,200);
//            shape1.setLineWidth(HSSFShape.LINEWIDTH_ONE_PT * 3);
//            shape1.setLineStyle(HSSFShape.LINESTYLE_DOTSYS);
        FileOutputStream fileOut = new FileOutputStream("XLDrawingShape.xls");
        try {
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    def reportePofesoresExcel () {
//        println("reportePofesoresExcel " + params)
//        def cn = dbConnectionService.getConnection()
//        def sql = ""
//        def prdo = Periodo.get(params.prdo)
//        def p_padre = prdo.tipo == 'I'? prdo.padre : 0
//        def p_hijo  = prdo.tipo == 'N'? Periodo.findByPadre(prdo) : 0
//        def fila = 4
//
//        XSSFWorkbook wb = new XSSFWorkbook()
//        XSSFCellStyle style = wb.createCellStyle();
//        XSSFFont font = wb.createFont();
//        font.setBold(true);
//        style.setFont(font);
//
//        XSSFCellStyle style2 = wb.createCellStyle();
//        XSSFFont font2 = wb.createFont();
//        font2.setBold(true);
//        style2.setFont(font2);
//        style2.setAlignment(HorizontalAlignment.CENTER);
//
//        XSSFCellStyle style3 = wb.createCellStyle();
//        XSSFFont font3 = wb.createFont();
//        style3.setWrapText(true);
//        style3.setFont(font3);
//        style3.setAlignment(HorizontalAlignment.LEFT);
//
//        XSSFCellStyle style4 = wb.createCellStyle();
//        XSSFFont font4 = wb.createFont();
//        style4.setWrapText(true);
//        style4.setFont(font4);
//        style4.setAlignment(HorizontalAlignment.RIGHT);
//
//        Sheet sheet = wb.createSheet("Período ${prdo.descripcion}")
//        sheet.setColumnWidth(0, 9 * 256);
//        sheet.setColumnWidth(1, 8 * 256);
//        sheet.setColumnWidth(2, 8 * 256);
//        sheet.setColumnWidth(3, 36 * 256);
//        sheet.setColumnWidth(4, 36 * 256);
//        sheet.setColumnWidth(5, 8 * 256);
//        sheet.setColumnWidth(6, 8 * 256);
//        sheet.setColumnWidth(7, 8 * 256);
//        sheet.setColumnWidth(8, 8 * 256);
//        sheet.setColumnWidth(9, 10 * 256);
//        sheet.setColumnWidth(10, 10 * 256);
//        sheet.setColumnWidth(11, 10 * 256);
//        sheet.setColumnWidth(12, 10 * 256);
//        sheet.setColumnWidth(13, 10 * 256);
//        sheet.setColumnWidth(14, 10 * 256);
//        sheet.setColumnWidth(15, 10 * 256);
//        sheet.setColumnWidth(16, 10 * 256);
//        sheet.setColumnWidth(17, 10 * 256);
//        sheet.setColumnWidth(18, 10 * 256);
//        sheet.setColumnWidth(19, 10 * 256);
//
//        Row row = sheet.createRow(0)
//        row.createCell(0).setCellValue("")
//        Row row2 = sheet.createRow(1)
//        if(params.profesor != 'null') {
//            def profesorNombre = Profesor.get(params.profesor)
//            row2.createCell(0).setCellValue("DOCENTE")
//            row2.createCell(1).setCellValue(profesorNombre?.apellido + " " + profesorNombre?.nombre)
//            row2.createCell(4).setCellValue("Período: ${prdo.descripcion}")
//        }else{
//            row2.createCell(1).setCellValue("LISTA DE DOCENTES")
//        }
//        row2.setRowStyle(style)
//        Row row4 = sheet.createRow(3)
//        row4.createCell(0).setCellValue("Fecha:")
//        row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
////        row4.sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
//        fila++
//
//        Row rowC1 = sheet.createRow(fila)
//        rowC1.createCell(0).setCellValue("Carrera")
//        rowC1.createCell(1).setCellValue("NRC")
//        rowC1.createCell(2).setCellValue("Código Banner")
//        rowC1.createCell(3).setCellValue("Nombre Asignatura o Actividad")
//        rowC1.createCell(4).setCellValue("Docente")
//        rowC1.createCell(5).setCellValue("Nivel")
//        rowC1.createCell(6).setCellValue("Paralelo")
//        rowC1.createCell(7).setCellValue("Teoría")
//        rowC1.createCell(8).setCellValue("Práctica")
//        rowC1.createCell(9).setCellValue("Horas Semana")
//        rowC1.createCell(10).setCellValue("Lunes ")
//        rowC1.createCell(11).setCellValue("Martes")
//        rowC1.createCell(12).setCellValue("Miércoles")
//        rowC1.createCell(13).setCellValue("Jueves")
//        rowC1.createCell(14).setCellValue("Viernes")
//        rowC1.createCell(15).setCellValue("Créditos")
//        rowC1.createCell(16).setCellValue("Factor Preparación")
//        rowC1.createCell(17).setCellValue("Horas Preparación")
//        rowC1.createCell(18).setCellValue("Horas gestión")
//        rowC1.createCell(19).setCellValue("Total horas")
//        rowC1.setRowStyle(style)
//        fila++
//
//        def profesor
//        def dicta
//        def gestion = []
//        def gestionN = []
//        def parl
//        def crso
//        def suma = 0
//
//        println "haciendo el reporte"
//
//        if(params.profesor != 'null'){
////            profesor = Profesor.get(params.profesor)
//            return reporteExcel(prdo?.id, params.profesor, false)
////            if(prdo.tipo == 'N'){
////                parl = Paralelo.findAllByPeriodo(prdo)
////                crso = Curso.findAllByParaleloInList(parl)
////                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
////                gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)
////            } else {
////                parl = Paralelo.findAllByPeriodo(prdo.padre)
////                crso = Curso.findAllByParaleloInList(parl)
////                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
////                gestionN = Gestion.findAllByProfesorAndPeriodo(profesor, prdo.padre)
////            }
////            println "dicta: $dicta"
////            gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)
//        }else{
////            return imprimeExcel(prdo?.id);
//            return reporteExcel(prdo?.id, 2, true)
////            parl = Paralelo.findAllByPeriodo(prdo)
////            crso = Curso.findAllByParaleloInList(parl)
////            dicta = Dicta.findAllByCursoInList(crso)
//        }
//
//        println "reporte unipersonal"
//        dicta.eachWithIndex { r, j ->
//            def respLunes = retornaHoras("lun", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
//            def respMartes = retornaHoras("mar", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
//            def respMiercoles = retornaHoras("mie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
//            def respJueves = retornaHoras("jue", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
//            def respViernes = retornaHoras("vie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
//
//            def horasAcad = 0
//
//            if(prdo.tipo == 'N') {
//                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() +
//                        (r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble())
//            } else {
//                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble()
//            }
//
//            Row rowF1 = sheet.createRow(fila)
//
//            Cell cell0 = rowF1.createCell(0);
//            cell0.setCellStyle(style3);
//            cell0.setCellValue(r?.curso?.asignatura?.carrera?.codigo?.toString());
//
//            Cell cell1 = rowF1.createCell(1);
//            cell1.setCellStyle(style3);
//            cell1.setCellValue(r?.curso?.nrc?.toString());
//
//            Cell cell2 = rowF1.createCell(2);
//            cell2.setCellStyle(style3);
//            cell2.setCellValue(r?.curso?.asignatura?.codigo?.toString());
//
//            Cell cell3 = rowF1.createCell(3);
//            cell3.setCellStyle(style3);
//            cell3.setCellValue(r?.curso?.asignatura?.nombre?.toString());
//
//            Cell cell4 = rowF1.createCell(4);
//            cell4.setCellStyle(style3);
//            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())
//
//            Cell cell5 = rowF1.createCell(5);
//            cell5.setCellStyle(style3);
//            cell5.setCellValue(r?.curso?.asignatura?.nivel?.numero?.toString())
//
//            Cell cell6 = rowF1.createCell(6);
//            cell6.setCellStyle(style3);
//            cell6.setCellValue(r?.curso?.paralelo?.numero?.toString())
//
//            Cell cell7 = rowF1.createCell(7);
//            cell7.setCellStyle(style4);
//            cell7.setCellValue(r?.curso?.asignatura?.horasTeoria?.toInteger())
//
//            Cell cell8 = rowF1.createCell(8);
//            cell8.setCellStyle(style4);
//            cell8.setCellValue(r?.curso?.asignatura?.horasPractica?.toInteger())
//
//            Cell cell9 = rowF1.createCell(9);
//            cell9.setCellStyle(style4);
//            cell9.setCellValue((r?.curso?.asignatura?.horasPractica?.toInteger() ?: 0) + (r?.curso?.asignatura?.horasTeoria?.toInteger() ?: 0))
//
//            Cell cell10 = rowF1.createCell(10);
//            cell10.setCellStyle(style3);
//            cell10.setCellValue(respLunes);
//
//            Cell cell11 = rowF1.createCell(11);
//            cell11.setCellStyle(style3);
//            cell11.setCellValue(respMartes);
//
//            Cell cell12 = rowF1.createCell(12);
//            cell12.setCellStyle(style3);
//            cell12.setCellValue(respMiercoles);
//
//            Cell cell13 = rowF1.createCell(13);
//            cell13.setCellStyle(style3);
//            cell13.setCellValue(respJueves);
//
//            Cell cell14 = rowF1.createCell(14);
//            cell14.setCellStyle(style3);
//            cell14.setCellValue(respViernes);
//
//            Cell cell15 = rowF1.createCell(15);
//            cell15.setCellStyle(style4);
//            cell15.setCellValue(r?.curso?.asignatura?.creditos?.toDouble());
//
//            Cell cell16 = rowF1.createCell(16);
//            cell16.setCellStyle(style4);
//            cell16.setCellValue(r?.curso?.asignatura?.factorPreparacion?.toDouble());
//
//            Cell cell17 = rowF1.createCell(17);
//            cell17.setCellStyle(style4);
//            cell17.setCellValue(r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble());
//
//            Cell cell18 = rowF1.createCell(18);
//            cell18.setCellStyle(style4);
//            cell18.setCellValue(r?.curso?.asignatura?.horasGestion?.toDouble());
//
//            Cell cell19 = rowF1.createCell(19);
//            cell19.setCellStyle(style4);
//            cell19.setCellValue(horasAcad);
//
//            suma += horasAcad
//            fila++
//        }
//
//        gestion.eachWithIndex { r, j ->
//            Row rowF1 = sheet.createRow(fila)
//
//
//            Cell cell0 = rowF1.createCell(0);
//            cell0.setCellStyle(style3);
//            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());
//
//            Cell cell1 = rowF1.createCell(1);
//            cell1.setCellStyle(style3);
//            cell1.setCellValue("");
//
//            Cell cell2 = rowF1.createCell(2);
//            cell2.setCellStyle(style3);
//            cell2.setCellValue(r?.asignatura?.codigo?.toString());
//
//            Cell cell3 = rowF1.createCell(3);
//            cell3.setCellStyle(style3);
//            cell3.setCellValue(r?.asignatura?.nombre?.toString());
//
//            Cell cell4 = rowF1.createCell(4);
//            cell4.setCellStyle(style3);
//            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())
//
//            Cell cell5 = rowF1.createCell(5);
//            cell5.setCellStyle(style3);
//            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())
//
//            Cell cell6 = rowF1.createCell(6);
//            cell6.setCellStyle(style3);
//            cell6.setCellValue("")
//
//            Cell cell7 = rowF1.createCell(7);
//            cell7.setCellStyle(style4);
//            cell7.setCellValue("")
//
//            Cell cell8 = rowF1.createCell(8);
//            cell8.setCellStyle(style4);
//            cell8.setCellValue("")
//
//            Cell cell9 = rowF1.createCell(9);
//            cell9.setCellStyle(style4);
//            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))
//
//            Cell cell10 = rowF1.createCell(10);
//            cell10.setCellStyle(style3);
//            cell10.setCellValue("");
//
//            Cell cell11 = rowF1.createCell(11);
//            cell11.setCellStyle(style3);
//            cell11.setCellValue("");
//
//            Cell cell12 = rowF1.createCell(12);
//            cell12.setCellStyle(style3);
//            cell12.setCellValue("");
//
//            Cell cell13 = rowF1.createCell(13);
//            cell13.setCellStyle(style3);
//            cell13.setCellValue("");
//
//            Cell cell14 = rowF1.createCell(14);
//            cell14.setCellStyle(style3);
//            cell14.setCellValue("");
//
//            Cell cell15 = rowF1.createCell(15);
//            cell15.setCellStyle(style4);
//            cell15.setCellValue(r?.hora?.toDouble()?:'');
//
//            Cell cell16 = rowF1.createCell(16);
//            cell16.setCellStyle(style4);
//            cell16.setCellValue(r?.asignatura?.factorPreparacion?.toDouble()?:'');
//
//            Cell cell17 = rowF1.createCell(17);
//            cell17.setCellStyle(style4);
//            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:'');
//
//            Cell cell18 = rowF1.createCell(18);
//            cell18.setCellStyle(style4);
//            cell18.setCellValue(r?.horas?.toDouble());
//
//            Cell cell19 = rowF1.createCell(19);
//            cell19.setCellStyle(style4);
//            cell19.setCellValue(r?.horas?.toDouble());
//
//            fila++
//            suma += r?.horas?.toDouble()
//        }
//
//        gestionN.eachWithIndex { r, j ->
//            Row rowF1 = sheet.createRow(fila)
//
//
//
//            Cell cell0 = rowF1.createCell(0);
//            cell0.setCellStyle(style3);
//            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());
//
//            Cell cell1 = rowF1.createCell(1);
//            cell1.setCellStyle(style3);
//            cell1.setCellValue("");
//
//            Cell cell2 = rowF1.createCell(2);
//            cell2.setCellStyle(style3);
//            cell2.setCellValue(r?.asignatura?.codigo?.toString());
//
//            Cell cell3 = rowF1.createCell(3);
//            cell3.setCellStyle(style3);
//            cell3.setCellValue(r?.asignatura?.nombre?.toString());
//
//            Cell cell4 = rowF1.createCell(4);
//            cell4.setCellStyle(style3);
//            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())
//
//            Cell cell5 = rowF1.createCell(5);
//            cell5.setCellStyle(style3);
//            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())
//
//            Cell cell6 = rowF1.createCell(6);
//            cell6.setCellStyle(style3);
//            cell6.setCellValue("")
//
//            Cell cell7 = rowF1.createCell(7);
//            cell7.setCellStyle(style4);
//            cell7.setCellValue("")
//
//            Cell cell8 = rowF1.createCell(8);
//            cell8.setCellStyle(style4);
//            cell8.setCellValue("")
//
//            Cell cell9 = rowF1.createCell(9);
//            cell9.setCellStyle(style4);
//            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))
//
//            Cell cell10 = rowF1.createCell(10);
//            cell10.setCellStyle(style3);
//            cell10.setCellValue("");
//
//            Cell cell11 = rowF1.createCell(11);
//            cell11.setCellStyle(style3);
//            cell11.setCellValue("");
//
//            Cell cell12 = rowF1.createCell(12);
//            cell12.setCellStyle(style3);
//            cell12.setCellValue("");
//
//            Cell cell13 = rowF1.createCell(13);
//            cell13.setCellStyle(style3);
//            cell13.setCellValue("");
//
//            Cell cell14 = rowF1.createCell(14);
//            cell14.setCellStyle(style3);
//            cell14.setCellValue("");
//
//            Cell cell15 = rowF1.createCell(15);
//            cell15.setCellStyle(style4);
//            cell15.setCellValue(r?.hora?.toDouble()?:'');
//
//            Cell cell16 = rowF1.createCell(16);
//            cell16.setCellStyle(style4);
//            cell16.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());
//
//            Cell cell17 = rowF1.createCell(17);
//            cell17.setCellStyle(style4);
//            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());
//
//            Cell cell18 = rowF1.createCell(18);
//            cell18.setCellStyle(style4);
//            cell18.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());
//
//            Cell cell19 = rowF1.createCell(19);
//            cell19.setCellStyle(style4);
//            cell19.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());
//
//
////            rowF1.createCell(19).setCellValue(r?.hora.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble())
////            rowF1.setRowStyle(style3)
//
//            fila++
//            suma += r?.hora.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble()
//        }
//
////        suma = 41.2 //borrar
//
//        Row rowF1 = sheet.createRow(fila)
//        rowF1.createCell(18).setCellValue("Total")
//        rowF1.createCell(19).setCellValue(suma)
//        rowF1.setRowStyle(style)
//
//        fila++
//
//
//
//        if(suma > 40 && prdo.tipo == 'N') {
//            Row rowS = sheet.createRow(fila)
//            rowS.createCell(1).setCellValue("El valor de ${Math.round((suma - 40)*10)/10} horas, que sobrepasa a las " +
//                    "40 horas semanales, se compensará en el periodo \"${p_hijo?.descripcion}\" como " +
//                    "${Math.round((suma - 40)*(prdo.semanas/p_hijo.semanas)*10)/10} horas de trabajo")
//            rowS.setRowStyle(style)
//        }
//
//        if(prdo.tipo == 'I') {
//            sql = "select comphora from res_prdo_n(${profesor.id}, ${p_padre.id})"
//            println "sql para ${prdo.tipo}: $sql"
//            def hh = cn.rows(sql.toString())[0].comphora
//            Row rowS = sheet.createRow(fila)
//            rowS.createCell(1).setCellValue("Compensación del periodo \"${p_padre?.descripcion}\" ${hh} horas de trabajo")
//            rowS.createCell(16).setCellValue("Compensación periodo ${p_padre?.descripcion}")
//            rowS.createCell(19).setCellValue(hh)
//            rowS.setRowStyle(style)
//            Row rowS1 = sheet.createRow(fila + 1)
//            rowS1.createCell(17).setCellValue("Total del periodo")
//            rowS1.createCell(19).setCellValue(suma + hh)
//            rowS1.setRowStyle(style)
//        }
//
//        def output = response.getOutputStream()
//        def header = "attachment; filename=" + "profesores.xlsx";
//        response.setContentType("application/octet-stream")
//        response.setHeader("Content-Disposition", header);
//        wb.write(output)
//    }

    def reportePofesoresExcel () {
        println("reportePofesoresExcel " + params)
        def periodo = Periodo.get(params.prdo)
        def prof = Profesor.get(params.profesor)

        XSSFWorkbook wb = new XSSFWorkbook()
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setBold(true);
        style2.setFont(font2);
        style2.setAlignment(HorizontalAlignment.CENTER);

        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        style3.setWrapText(true);
        style3.setFont(font3);
        style3.setAlignment(HorizontalAlignment.LEFT);

        XSSFCellStyle style4 = wb.createCellStyle();
        XSSFFont font4 = wb.createFont();
        style4.setWrapText(true);
        style4.setFont(font4);
        style4.setAlignment(HorizontalAlignment.RIGHT);

        Sheet sheet = wb.createSheet("Período ${periodo.descripcion}")

        sheet.setColumnWidth(0, 9 * 256);
        sheet.setColumnWidth(1, 8 * 256);
        sheet.setColumnWidth(2, 8 * 256);
        sheet.setColumnWidth(3, 36 * 256);
        sheet.setColumnWidth(4, 36 * 256);
        sheet.setColumnWidth(5, 8 * 256);
        sheet.setColumnWidth(6, 8 * 256);
        sheet.setColumnWidth(7, 8 * 256);
        sheet.setColumnWidth(8, 8 * 256);
        sheet.setColumnWidth(9, 10 * 256);
        sheet.setColumnWidth(10, 10 * 256);
        sheet.setColumnWidth(11, 10 * 256);
        sheet.setColumnWidth(12, 10 * 256);
        sheet.setColumnWidth(13, 10 * 256);
        sheet.setColumnWidth(14, 10 * 256);
        sheet.setColumnWidth(15, 10 * 256);
        sheet.setColumnWidth(16, 10 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 10 * 256);
        sheet.setColumnWidth(19, 10 * 256);

        Row row = sheet.createRow(0)
        row.createCell(0).setCellValue("")
        Row row2 = sheet.createRow(1)

        row2.createCell(0).setCellValue("DOCENTE")
        row2.createCell(1).setCellValue(prof?.apellido + " " + prof?.nombre)
        row2.createCell(4).setCellValue("Perìodo: ${periodo.descripcion}")

        row2.setRowStyle(style)
        Row row4 = sheet.createRow(3)
        row4.createCell(0).setCellValue("Fecha:")
        row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))

        def fila = 4

        if(params.profesor != 'null'){
            reporteExcel(sheet, params.prdo, params.profesor, false, style, style2, style3, style4, fila)
            def output = response.getOutputStream()
            def header = "attachment; filename=" + "profesor_${prof?.apellido + " " + prof?.nombre}.xlsx";
            response.setContentType("application/octet-stream")
            response.setHeader("Content-Disposition", header);
            wb.write(output)
            println "Salida"
            return
        }else{
            def profesores = Profesor.list([sort: 'apellido'])
            profesores.each { p ->
                fila = reporteExcel(sheet, params.prdo, p?.id, true, style, style2, style3, style4, fila)
                if(params.arch == 'true') {
                    reporteExcel(sheet, params.prdo, p?.id, true, style, style2, style3, style4, 4)
                    def file = new File("/tmp/profesor_${p?.apellido + "_" + p?.nombre}.xlsx")
                    FileOutputStream outputStream = new FileOutputStream(file)
                    wb.write(outputStream)
                }
            }

            if(params.arch == 'false') {
                println "Genera el archivo de todos los profesores --> ${params.arch}"
                def file = new File("/tmp/prog_acad_${params.prdo}.xlsx")
                FileOutputStream outputStream = new FileOutputStream(file)
                wb.write(outputStream)
            }


            flash.message = "Se han generado los archivos excel con los reportes de todos los profesores."
            flash.tipo = "info"
            flash.icon = "icon-warning"
            redirect(controller: "reportes", action: "reportes")
        }


//        println "--> ${profesor?.apellido + "_" + profesor?.nombre}"
//        if(generaArch) {
//            def file = new File("/tmp/profesor_${profesor?.apellido + "_" + profesor?.nombre}.xlsx")
//            FileOutputStream outputStream = new FileOutputStream(file)
//            wb.write(outputStream)
//        } else {
//            def output = response.getOutputStream()
//            def header = "attachment; filename=" + "profesor_${profesor?.apellido + " " + profesor?.nombre}.xlsx";
//            response.setContentType("application/octet-stream")
//            response.setHeader("Content-Disposition", header);
//            wb.write(output)
//        }

    }


    def retornaHoras(dia, nivel, paralelo, asignatura){
        def arreglo = []
        def cn = dbConnectionService.getConnection()
//        def sql = "select horadscr from hora where hora__id in (select substr(${dia},3,1)::int " +
//                "from horario(${nivel}, ${paralelo}, ${asignatura}) where length(${dia}) > 4) order by horanmro"
//        def sql = "select hora from horario(${nivel}, ${paralelo}, ${asignatura}) where length(${dia}) > 10 and " +
//                "split_part(${dia}, ';', 4) = 'S' order by hora"
        def sql = "select horadscr from hora where hora__id in (select split_part(mar, ';',2)::int " +
                "from horario(${nivel}, ${paralelo}, ${asignatura}) where length(${dia}) > 10 and " +
                "split_part(${dia}, ';', 4) = 'S') order by horanmro"
        if(asignatura == 86) {
            println "sql: $sql"
        }
        def resp = cn.rows(sql.toString())
        resp.each {
            arreglo.add(it.horadscr)
        }
        return horario(arreglo)
    }

    def horario(txto) {
        def primero = ""
        def ultimo = ""
        def retorna = ""
        if(txto.size() > 1) {
            primero = txto[0]
            ultimo = txto[-1]
        } else if(txto.size() == 1) {
            primero = txto[0]
            ultimo = txto[-1]
        }
        if((primero + ultimo) != "") {
            retorna = primero.split('-')[0] + "-" + ultimo.split('-')[1]
        }
        return retorna
    }

    def profesores_ajax(){

    }

    def horario_ajax(){

    }

    def paralelo_ajax(){
        def periodo = Periodo.get(params.periodo)
        def nivel = Nivel.get(params.nivel)
        def paralelos = Paralelo.findAllByPeriodoAndNivel(periodo, nivel)
        def asignaturas = Asignatura.findAllByNivel(nivel)
        return[paralelos: paralelos, asignaturas: asignaturas]
    }


    def reporteHorarioExcel(){
//        println("params hora excel " + params)
        def cn = dbConnectionService.getConnection()
        def asignatura = Asignatura.get(params.asignatura)
        def sql = "select * from horario(${asignatura.nivel.id}, ${params.paralelo}, ${params.asignatura})"
//        println("sql " + sql)
        def resp = cn.rows(sql.toString())
        def fila = 4

        def horr, prof

        XSSFWorkbook wb = new XSSFWorkbook()
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setBold(true);
        style2.setFont(font2);
        style2.setAlignment(HorizontalAlignment.LEFT);

        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        style3.setWrapText(true);
        style3.setFont(font3);
        style3.setAlignment(HorizontalAlignment.LEFT);

        XSSFCellStyle style4 = wb.createCellStyle();
        XSSFFont font4 = wb.createFont();
        style4.setWrapText(true);
        style4.setFont(font4);
        style4.setAlignment(HorizontalAlignment.RIGHT);

        Sheet sheet = wb.createSheet("Horario")
        sheet.setColumnWidth(0, 30 * 256);
        sheet.setColumnWidth(1, 30 * 256);
        sheet.setColumnWidth(2, 30 * 256);
        sheet.setColumnWidth(3, 30 * 256);
        sheet.setColumnWidth(4, 30 * 256);
        sheet.setColumnWidth(5, 30 * 256);
        sheet.setColumnWidth(6, 30 * 256);
        sheet.setColumnWidth(7, 30 * 256);

        Row row = sheet.createRow(0)
        row.createCell(0).setCellValue("")
        Row row2 = sheet.createRow(1)
        row2.setRowStyle(style)
        Row row4 = sheet.createRow(3)
        row4.createCell(0).setCellValue("Fecha:")
        row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
//        row4.sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
        fila++

        Row rowC1 = sheet.createRow(fila)
        rowC1.createCell(0).setCellValue("Hora")
        rowC1.createCell(1).setCellValue("Lunes")
        rowC1.createCell(2).setCellValue("Martes")
        rowC1.createCell(3).setCellValue("Miércoles")
        rowC1.createCell(4).setCellValue("Jueves")
        rowC1.createCell(5).setCellValue("Viernes")
        rowC1.setRowStyle(style)
        fila++

        resp.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)
            rowF1.setHeight((short) 650)

            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style2);
            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style2);
            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style2);
            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style2);
            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style2);

            cell0.setCellValue(r?.hora?.toString());

            if(r?.lun?.size() > 7){
                horr = Horario.get(r?.lun?.split(';')[2])
                prof = Dicta.findByCurso(horr.curso)
                cell1.setCellValue("${horr.curso.asignatura.nombre} \n${prof.profesor.apellido} ${prof.profesor.nombre}");
            }else{
                cell1.setCellValue("")
            }

            if(r?.mar?.size() > 7){
                horr = Horario.get(r?.mar?.split(';')[2])
                prof = Dicta.findByCurso(horr.curso)
                cell2.setCellValue("${horr.curso.asignatura.nombre} \n${prof.profesor.apellido} ${prof.profesor.nombre}");
            }else{
                cell2.setCellValue("")
            }

            if(r?.mie?.size() > 7){
                horr = Horario.get(r?.mie?.split(';')[2])
                prof = Dicta.findByCurso(horr.curso)
                cell3.setCellValue("${horr.curso.asignatura.nombre} \n${prof.profesor.apellido} ${prof.profesor.nombre}");
            }else{
                cell3.setCellValue("")
            }

            if(r?.jue?.size() > 7){
                horr = Horario.get(r?.jue?.split(';')[2])
                prof = Dicta.findByCurso(horr.curso)
                cell4.setCellValue("${horr.curso.asignatura.nombre} \n${prof.profesor.apellido} ${prof.profesor.nombre}");
            }else{
                cell4.setCellValue("")
            }

            if(r?.vie?.size() > 7){
                horr = Horario.get(r?.vie?.split(';')[2])
                prof = Dicta.findByCurso(horr.curso)
                cell5.setCellValue("${horr.curso.asignatura.nombre} \n${prof.profesor.apellido} ${prof.profesor.nombre}");
            }else{
                cell5.setCellValue("")
            }

            fila++
        }

        def output = response.getOutputStream()
        def header = "attachment; filename=" + "horario.xlsx";
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", header);
        wb.write(output)

    }

    def reportePeriodoExcel(){
        println("params periodo excel " + params)
        def cn = dbConnectionService.getConnection()

        def sql = "select carrnmbr, nveldscr, parlnmro, profapll, profnmbr, asignmbr from carr, nvel, " +
                "parl, dcta, prof, crso, asig where prdo__id = 2 and nvel.nvel__id = parl.nvel__id and " +
                "carr.carr__id = parl.carr__id and crso.parl__id = parl.parl__id and dcta.crso__id = crso.crso__id and " +
                "prof.prof__id = dcta.prof__id and asig.asig__id = crso.asig__id order by carr.carr__id, nvel.nvelnmro, parlnmro, profapll;"

        def resp = cn.rows(sql.toString())
        def fila = 4

        XSSFWorkbook wb = new XSSFWorkbook()
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setBold(true);
        style2.setFont(font2);
        style2.setAlignment(HorizontalAlignment.CENTER);

        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        style3.setWrapText(true);
        style3.setFont(font3);
        style3.setAlignment(HorizontalAlignment.LEFT);

        XSSFCellStyle style4 = wb.createCellStyle();
        XSSFFont font4 = wb.createFont();
        style4.setWrapText(true);
        style4.setFont(font4);
        style4.setAlignment(HorizontalAlignment.RIGHT);

        Sheet sheet = wb.createSheet("Horario")
        sheet.setColumnWidth(0, 20 * 256);
        sheet.setColumnWidth(1, 20 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 20 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 40 * 256);

        Row row = sheet.createRow(0)
        row.createCell(0).setCellValue("")
        Row row2 = sheet.createRow(1)
        row2.setRowStyle(style)
        Row row4 = sheet.createRow(3)
        row4.createCell(0).setCellValue("Fecha:")
        row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
//        row4.sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
        fila++

        Row rowC1 = sheet.createRow(fila)
        rowC1.createCell(0).setCellValue("Carrera")
        rowC1.createCell(1).setCellValue("Nivel")
        rowC1.createCell(2).setCellValue("Paralelo")
        rowC1.createCell(3).setCellValue("Apellido")
        rowC1.createCell(4).setCellValue("Nombre")
        rowC1.createCell(5).setCellValue("Asignatura")
        rowC1.setRowStyle(style)
        fila++

        resp.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)
            rowF1.createCell(0).setCellValue(r?.carrnmbr?.toString())
            rowF1.createCell(1).setCellValue(r?.nveldscr?.toString())
            rowF1.createCell(2).setCellValue(r?.parlnmro?.toString())
            rowF1.createCell(3).setCellValue(r?.profapll?.toString())
            rowF1.createCell(4).setCellValue(r?.profnmbr?.toString())
            rowF1.createCell(5).setCellValue(r?.asignmbr?.toString())
            fila++
        }

        //escribe a archivo
//        def file = new File("/tmp/prueba.xlsx")
//        FileOutputStream outputStream = new FileOutputStream(file)
//        wb.write(outputStream)

        def output = response.getOutputStream()
        def header = "attachment; filename=" + "periodo.xlsx";
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", header);
        wb.write(output)
    }


    def imprimeExcel (periodo) {
        println("imprime " + params)

        def cn = dbConnectionService.getConnection()
        def sql = ""
        def prdo = Periodo.get(periodo)
        def p_padre = prdo.tipo == 'I'? prdo.padre : 0
        def p_hijo  = prdo.tipo == 'N'? Periodo.findByPadre(prdo) : 0


        def profesores = Profesor.list()

        profesores.each { p->

            def fila = 4

            XSSFWorkbook wb = new XSSFWorkbook()
            XSSFCellStyle style = wb.createCellStyle();
            XSSFFont font = wb.createFont();
            font.setBold(true);
            style.setFont(font);

            XSSFCellStyle style2 = wb.createCellStyle();
            XSSFFont font2 = wb.createFont();
            font2.setBold(true);
            style2.setFont(font2);
            style2.setAlignment(HorizontalAlignment.CENTER);

            XSSFCellStyle style3 = wb.createCellStyle();
            XSSFFont font3 = wb.createFont();
            style3.setWrapText(true);
            style3.setFont(font3);
            style3.setAlignment(HorizontalAlignment.LEFT);

            XSSFCellStyle style4 = wb.createCellStyle();
            XSSFFont font4 = wb.createFont();
            style4.setWrapText(true);
            style4.setFont(font4);
            style4.setAlignment(HorizontalAlignment.RIGHT);

            Sheet sheet = wb.createSheet("Período ${prdo.descripcion}")
            sheet.setColumnWidth(0, 9 * 256);
            sheet.setColumnWidth(1, 8 * 256);
            sheet.setColumnWidth(2, 8 * 256);
            sheet.setColumnWidth(3, 36 * 256);
            sheet.setColumnWidth(4, 36 * 256);
            sheet.setColumnWidth(5, 8 * 256);
            sheet.setColumnWidth(6, 8 * 256);
            sheet.setColumnWidth(7, 8 * 256);
            sheet.setColumnWidth(8, 8 * 256);
            sheet.setColumnWidth(9, 10 * 256);
            sheet.setColumnWidth(10, 10 * 256);
            sheet.setColumnWidth(11, 10 * 256);
            sheet.setColumnWidth(12, 10 * 256);
            sheet.setColumnWidth(13, 10 * 256);
            sheet.setColumnWidth(14, 10 * 256);
            sheet.setColumnWidth(15, 10 * 256);
            sheet.setColumnWidth(16, 10 * 256);
            sheet.setColumnWidth(17, 10 * 256);
            sheet.setColumnWidth(18, 10 * 256);
            sheet.setColumnWidth(19, 10 * 256);

            Row row = sheet.createRow(0)
            row.createCell(0).setCellValue("")
            Row row2 = sheet.createRow(1)

            def profesorNombre = Profesor.get(p?.id)
            row2.createCell(0).setCellValue("DOCENTE")
            row2.createCell(1).setCellValue(profesorNombre?.apellido + " " + profesorNombre?.nombre)
            row2.createCell(4).setCellValue("Perìodo: ${prdo.descripcion}")

            row2.setRowStyle(style)
            Row row4 = sheet.createRow(3)
            row4.createCell(0).setCellValue("Fecha:")
            row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
            fila++

            Row rowC1 = sheet.createRow(fila)
            rowC1.createCell(0).setCellValue("Carrera")
            rowC1.createCell(1).setCellValue("NRC")
            rowC1.createCell(2).setCellValue("Código Banner")
            rowC1.createCell(3).setCellValue("Nombre Asignatura o Actividad")
            rowC1.createCell(4).setCellValue("Docente")
            rowC1.createCell(5).setCellValue("Nivel")
            rowC1.createCell(6).setCellValue("Paralelo")
            rowC1.createCell(7).setCellValue("Teoría")
            rowC1.createCell(8).setCellValue("Práctica")
            rowC1.createCell(9).setCellValue("Horas Semana")
            rowC1.createCell(10).setCellValue("Lunes ")
            rowC1.createCell(11).setCellValue("Martes")
            rowC1.createCell(12).setCellValue("Miércoles")
            rowC1.createCell(13).setCellValue("Jueves")
            rowC1.createCell(14).setCellValue("Viernes")
            rowC1.createCell(15).setCellValue("Créditos")
            rowC1.createCell(16).setCellValue("Factor Preparación")
            rowC1.createCell(17).setCellValue("Horas Preparación")
            rowC1.createCell(18).setCellValue("Horas gestión")
            rowC1.createCell(19).setCellValue("Total horas")
            rowC1.setRowStyle(style)
            fila++

            def profesor
            def dicta
            def gestion = []
            def gestionN = []
            def parl
            def crso
            def suma = 0

            profesor = Profesor.get(p?.id)
            if(prdo.tipo == 'N'){
                parl = Paralelo.findAllByPeriodo(prdo)
                crso = Curso.findAllByParaleloInList(parl)
                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
                gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)
            } else {
                parl = Paralelo.findAllByPeriodo(prdo.padre)
                crso = Curso.findAllByParaleloInList(parl)
                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
                gestionN = Gestion.findAllByProfesorAndPeriodo(profesor, prdo.padre)
            }
            gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)

            dicta.eachWithIndex { r, j ->
                def respLunes = retornaHoras("lun", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
                def respMartes = retornaHoras("mar", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
                def respMiercoles = retornaHoras("mie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
                def respJueves = retornaHoras("jue", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
                def respViernes = retornaHoras("vie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)

                def horasAcad = 0

                if(prdo.tipo == 'N') {
                    horasAcad = r?.curso?.asignatura?.creditos?.toInteger() +
                            (r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble())
                } else {
                    horasAcad = r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble()
                }

                Row rowF1 = sheet.createRow(fila)

                Cell cell0 = rowF1.createCell(0);
                cell0.setCellStyle(style3);
                cell0.setCellValue(r?.curso?.asignatura?.carrera?.codigo?.toString());

                Cell cell1 = rowF1.createCell(1);
                cell1.setCellStyle(style3);
                cell1.setCellValue(r?.curso?.nrc?.toString());

                Cell cell2 = rowF1.createCell(2);
                cell2.setCellStyle(style3);
                cell2.setCellValue(r?.curso?.asignatura?.codigo?.toString());

                Cell cell3 = rowF1.createCell(3);
                cell3.setCellStyle(style3);
                cell3.setCellValue(r?.curso?.asignatura?.nombre?.toString());

                Cell cell4 = rowF1.createCell(4);
                cell4.setCellStyle(style3);
                cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

                Cell cell5 = rowF1.createCell(5);
                cell5.setCellStyle(style3);
                cell5.setCellValue(r?.curso?.asignatura?.nivel?.numero?.toString())

                Cell cell6 = rowF1.createCell(6);
                cell6.setCellStyle(style3);
                cell6.setCellValue(r?.curso?.paralelo?.numero?.toString())

                Cell cell7 = rowF1.createCell(7);
                cell7.setCellStyle(style4);
                cell7.setCellValue(r?.curso?.asignatura?.horasTeoria?.toInteger())

                Cell cell8 = rowF1.createCell(8);
                cell8.setCellStyle(style4);
                cell8.setCellValue(r?.curso?.asignatura?.horasPractica?.toInteger())

                Cell cell9 = rowF1.createCell(9);
                cell9.setCellStyle(style4);
                cell9.setCellValue((r?.curso?.asignatura?.horasPractica?.toInteger() ?: 0) + (r?.curso?.asignatura?.horasTeoria?.toInteger() ?: 0))

                Cell cell10 = rowF1.createCell(10);
                cell10.setCellStyle(style3);
                cell10.setCellValue(respLunes);

                Cell cell11 = rowF1.createCell(11);
                cell11.setCellStyle(style3);
                cell11.setCellValue(respMartes);

                Cell cell12 = rowF1.createCell(12);
                cell12.setCellStyle(style3);
                cell12.setCellValue(respMiercoles);

                Cell cell13 = rowF1.createCell(13);
                cell13.setCellStyle(style3);
                cell13.setCellValue(respJueves);

                Cell cell14 = rowF1.createCell(14);
                cell14.setCellStyle(style3);
                cell14.setCellValue(respViernes);

                Cell cell15 = rowF1.createCell(15);
                cell15.setCellStyle(style4);
                cell15.setCellValue(r?.curso?.asignatura?.creditos?.toDouble());

                Cell cell16 = rowF1.createCell(16);
                cell16.setCellStyle(style4);
                cell16.setCellValue(r?.curso?.asignatura?.factorPreparacion?.toDouble());

                Cell cell17 = rowF1.createCell(17);
                cell17.setCellStyle(style4);
                cell17.setCellValue(r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble());

                Cell cell18 = rowF1.createCell(18);
                cell18.setCellStyle(style4);
                cell18.setCellValue(r?.curso?.asignatura?.horasGestion?.toDouble());

                Cell cell19 = rowF1.createCell(19);
                cell19.setCellStyle(style4);
                cell19.setCellValue(horasAcad);

                suma += horasAcad
                fila++
            }

            gestion.eachWithIndex { r, j ->
                Row rowF1 = sheet.createRow(fila)


                Cell cell0 = rowF1.createCell(0);
                cell0.setCellStyle(style3);
                cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

                Cell cell1 = rowF1.createCell(1);
                cell1.setCellStyle(style3);
                cell1.setCellValue("");

                Cell cell2 = rowF1.createCell(2);
                cell2.setCellStyle(style3);
                cell2.setCellValue(r?.asignatura?.codigo?.toString());

                Cell cell3 = rowF1.createCell(3);
                cell3.setCellStyle(style3);
                cell3.setCellValue(r?.asignatura?.nombre?.toString());

                Cell cell4 = rowF1.createCell(4);
                cell4.setCellStyle(style3);
                cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

                Cell cell5 = rowF1.createCell(5);
                cell5.setCellStyle(style3);
                cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

                Cell cell6 = rowF1.createCell(6);
                cell6.setCellStyle(style3);
                cell6.setCellValue("")

                Cell cell7 = rowF1.createCell(7);
                cell7.setCellStyle(style4);
                cell7.setCellValue("")

                Cell cell8 = rowF1.createCell(8);
                cell8.setCellStyle(style4);
                cell8.setCellValue("")

                Cell cell9 = rowF1.createCell(9);
                cell9.setCellStyle(style4);
                cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

                Cell cell10 = rowF1.createCell(10);
                cell10.setCellStyle(style3);
                cell10.setCellValue("");

                Cell cell11 = rowF1.createCell(11);
                cell11.setCellStyle(style3);
                cell11.setCellValue("");

                Cell cell12 = rowF1.createCell(12);
                cell12.setCellStyle(style3);
                cell12.setCellValue("");

                Cell cell13 = rowF1.createCell(13);
                cell13.setCellStyle(style3);
                cell13.setCellValue("");

                Cell cell14 = rowF1.createCell(14);
                cell14.setCellStyle(style3);
                cell14.setCellValue("");

                Cell cell15 = rowF1.createCell(15);
                cell15.setCellStyle(style4);
                cell15.setCellValue(r?.hora?.toDouble()?:'');

                Cell cell16 = rowF1.createCell(16);
                cell16.setCellStyle(style4);
                cell16.setCellValue(r?.asignatura?.factorPreparacion?.toDouble()?:'');

                Cell cell17 = rowF1.createCell(17);
                cell17.setCellStyle(style4);
                cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:'');

                Cell cell18 = rowF1.createCell(18);
                cell18.setCellStyle(style4);
                cell18.setCellValue(r?.horas?.toDouble());

                Cell cell19 = rowF1.createCell(19);
                cell19.setCellStyle(style4);
                cell19.setCellValue(r?.horas?.toDouble());

                fila++
                suma += r?.horas?.toDouble()
            }

            gestionN.eachWithIndex { r, j ->
                Row rowF1 = sheet.createRow(fila)

                Cell cell0 = rowF1.createCell(0);
                cell0.setCellStyle(style3);
                cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

                Cell cell1 = rowF1.createCell(1);
                cell1.setCellStyle(style3);
                cell1.setCellValue("");

                Cell cell2 = rowF1.createCell(2);
                cell2.setCellStyle(style3);
                cell2.setCellValue(r?.asignatura?.codigo?.toString());

                Cell cell3 = rowF1.createCell(3);
                cell3.setCellStyle(style3);
                cell3.setCellValue(r?.asignatura?.nombre?.toString());

                Cell cell4 = rowF1.createCell(4);
                cell4.setCellStyle(style3);
                cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

                Cell cell5 = rowF1.createCell(5);
                cell5.setCellStyle(style3);
                cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

                Cell cell6 = rowF1.createCell(6);
                cell6.setCellStyle(style3);
                cell6.setCellValue("")

                Cell cell7 = rowF1.createCell(7);
                cell7.setCellStyle(style4);
                cell7.setCellValue("")

                Cell cell8 = rowF1.createCell(8);
                cell8.setCellStyle(style4);
                cell8.setCellValue("")

                Cell cell9 = rowF1.createCell(9);
                cell9.setCellStyle(style4);
                cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

                Cell cell10 = rowF1.createCell(10);
                cell10.setCellStyle(style3);
                cell10.setCellValue("");

                Cell cell11 = rowF1.createCell(11);
                cell11.setCellStyle(style3);
                cell11.setCellValue("");

                Cell cell12 = rowF1.createCell(12);
                cell12.setCellStyle(style3);
                cell12.setCellValue("");

                Cell cell13 = rowF1.createCell(13);
                cell13.setCellStyle(style3);
                cell13.setCellValue("");

                Cell cell14 = rowF1.createCell(14);
                cell14.setCellStyle(style3);
                cell14.setCellValue("");

                Cell cell15 = rowF1.createCell(15);
                cell15.setCellStyle(style4);
                cell15.setCellValue(r?.hora?.toDouble()?:'');

                Cell cell16 = rowF1.createCell(16);
                cell16.setCellStyle(style4);
                cell16.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

                Cell cell17 = rowF1.createCell(17);
                cell17.setCellStyle(style4);
                cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

                Cell cell18 = rowF1.createCell(18);
                cell18.setCellStyle(style4);
                cell18.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

                Cell cell19 = rowF1.createCell(19);
                cell19.setCellStyle(style4);
                cell19.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

                fila++
                suma += r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble()
            }

            Row rowF1 = sheet.createRow(fila)
            rowF1.createCell(18).setCellValue("Total")
            rowF1.createCell(19).setCellValue(suma)
            rowF1.setRowStyle(style)

            fila++

            if(suma > 40 && prdo.tipo == 'N') {
                Row rowS = sheet.createRow(fila)
                rowS.createCell(1).setCellValue("El valor de ${Math.round((suma - 40)*10)/10} horas, que sobrepasa a las " +
                        "40 horas semanales, se compensará en el periodo \"${p_hijo?.descripcion}\" como " +
                        "${Math.round((suma - 40)*(prdo.semanas/p_hijo.semanas)*10)/10} horas de trabajo")
                rowS.setRowStyle(style)
            }

            if(prdo.tipo == 'I') {
                sql = "select comphora from res_prdo_n(${profesor.id}, ${p_padre.id})"
                println "sql para ${prdo.tipo}: $sql"
                def hh = cn.rows(sql.toString())[0].comphora
                Row rowS = sheet.createRow(fila)
                rowS.createCell(1).setCellValue("Compensación del periodo \"${p_padre?.descripcion}\" ${hh} horas de trabajo")
                rowS.createCell(16).setCellValue("Compensación periodo ${p_padre?.descripcion}")
                rowS.createCell(19).setCellValue(hh)
                rowS.setRowStyle(style)
                Row rowS1 = sheet.createRow(fila + 1)
                rowS1.createCell(17).setCellValue("Total del periodo")
                rowS1.createCell(19).setCellValue(suma + hh)
                rowS1.setRowStyle(style)
            }

//            def file = new File("/tmp/profesor_${profesor?.apellido + "_" + profesor?.nombre}.xlsx")
//            FileOutputStream outputStream = new FileOutputStream(file)
//            wb.write(outputStream)

            println "--> ${profesor?.apellido + "_" + profesor?.nombre}"
//            def output = response.getOutputStream()
//            def header = "attachment; filename=" + "profesor_${profesor?.apellido + " " + profesor?.nombre}.xlsx";
//            response.setContentType("application/octet-stream")
//            response.setHeader("Content-Disposition", header);
//            wb.write(output)

        }
//        render "se han generado los archivos excel con los reportes de todos los profesores"
        flash.message = "Se han generado los archivos excel con los reportes de todos los profesores."
        flash.tipo = "info"
        flash.icon = "icon-warning"
        redirect(controller: "reportes", action: "reportes")

    }

    def reporteExcel(sheet, prdo, prof, generaArch, style, style2, style3, style4, nmro) {
        println "genera excel para: prdo = $prdo y prof: $prof"

        def cn = dbConnectionService.getConnection()
        def sql = ""
        def periodo = Periodo.get(prdo)
        def p_padre = periodo.tipo == 'I'? periodo.padre : 0
        def p_hijo  = periodo.tipo == 'N'? Periodo.findByPadre(periodo) : 0

        def p = Profesor.get(prof)

        def fila = nmro   //4

//            XSSFWorkbook wb = new XSSFWorkbook()
//            XSSFCellStyle style = wb.createCellStyle();
//            XSSFFont font = wb.createFont();
//            font.setBold(true);
//            style.setFont(font);
//
//            XSSFCellStyle style2 = wb.createCellStyle();
//            XSSFFont font2 = wb.createFont();
//            font2.setBold(true);
//            style2.setFont(font2);
//            style2.setAlignment(HorizontalAlignment.CENTER);
//
//            XSSFCellStyle style3 = wb.createCellStyle();
//            XSSFFont font3 = wb.createFont();
//            style3.setWrapText(true);
//            style3.setFont(font3);
//            style3.setAlignment(HorizontalAlignment.LEFT);
//
//            XSSFCellStyle style4 = wb.createCellStyle();
//            XSSFFont font4 = wb.createFont();
//            style4.setWrapText(true);
//            style4.setFont(font4);
//            style4.setAlignment(HorizontalAlignment.RIGHT);
//
//            Sheet sheet = wb.createSheet("Período ${periodo.descripcion}")

//            sheet.setColumnWidth(0, 9 * 256);
//            sheet.setColumnWidth(1, 8 * 256);
//            sheet.setColumnWidth(2, 8 * 256);
//            sheet.setColumnWidth(3, 36 * 256);
//            sheet.setColumnWidth(4, 36 * 256);
//            sheet.setColumnWidth(5, 8 * 256);
//            sheet.setColumnWidth(6, 8 * 256);
//            sheet.setColumnWidth(7, 8 * 256);
//            sheet.setColumnWidth(8, 8 * 256);
//            sheet.setColumnWidth(9, 10 * 256);
//            sheet.setColumnWidth(10, 10 * 256);
//            sheet.setColumnWidth(11, 10 * 256);
//            sheet.setColumnWidth(12, 10 * 256);
//            sheet.setColumnWidth(13, 10 * 256);
//            sheet.setColumnWidth(14, 10 * 256);
//            sheet.setColumnWidth(15, 10 * 256);
//            sheet.setColumnWidth(16, 10 * 256);
//            sheet.setColumnWidth(17, 10 * 256);
//            sheet.setColumnWidth(18, 10 * 256);
//            sheet.setColumnWidth(19, 10 * 256);

//            Row row = sheet.createRow(0)
//            row.createCell(0).setCellValue("")
//            Row row2 = sheet.createRow(1)
//
//            def profesorNombre = Profesor.get(p?.id)
//            row2.createCell(0).setCellValue("DOCENTE")
//            row2.createCell(1).setCellValue(profesorNombre?.apellido + " " + profesorNombre?.nombre)
//            row2.createCell(4).setCellValue("Perìodo: ${periodo.descripcion}")
//
//            row2.setRowStyle(style)
//            Row row4 = sheet.createRow(3)
//            row4.createCell(0).setCellValue("Fecha:")
//            row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
//            fila++

        Row rowC1 = sheet.createRow(fila)
        rowC1.createCell(0).setCellValue("Carrera")
        rowC1.createCell(1).setCellValue("NRC")
        rowC1.createCell(2).setCellValue("Código Banner")
        rowC1.createCell(3).setCellValue("Nombre Asignatura o Actividad")
        rowC1.createCell(4).setCellValue("Docente")
        rowC1.createCell(5).setCellValue("Nivel")
        rowC1.createCell(6).setCellValue("Paralelo")
        rowC1.createCell(7).setCellValue("Teoría")
        rowC1.createCell(8).setCellValue("Práctica")
        rowC1.createCell(9).setCellValue("Horas Semana")
        rowC1.createCell(10).setCellValue("Lunes ")
        rowC1.createCell(11).setCellValue("Martes")
        rowC1.createCell(12).setCellValue("Miércoles")
        rowC1.createCell(13).setCellValue("Jueves")
        rowC1.createCell(14).setCellValue("Viernes")
        rowC1.createCell(15).setCellValue("Créditos")
        rowC1.createCell(16).setCellValue("Factor Preparación")
        rowC1.createCell(17).setCellValue("Horas Preparación")
        rowC1.createCell(18).setCellValue("Horas gestión")
        rowC1.createCell(19).setCellValue("Total horas")
        rowC1.setRowStyle(style)
        fila++

        def profesor
        def dicta
        def gestion = []
        def gestionN = []
        def parl
        def crso
        def suma = 0

        profesor = Profesor.get(p?.id)
        if(periodo.tipo == 'N'){
            parl = Paralelo.findAllByPeriodo(periodo)
            crso = Curso.findAllByParaleloInList(parl)
            dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
            gestion = Gestion.findAllByProfesorAndPeriodo(profesor, periodo)
        } else {
            parl = Paralelo.findAllByPeriodo(periodo.padre)
            crso = Curso.findAllByParaleloInList(parl)
            dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
            gestionN = Gestion.findAllByProfesorAndPeriodo(profesor, periodo.padre)
        }
        gestion = Gestion.findAllByProfesorAndPeriodo(profesor, periodo)

        dicta.eachWithIndex { r, j ->
            def respLunes = retornaHoras("lun", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respMartes = retornaHoras("mar", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respMiercoles = retornaHoras("mie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respJueves = retornaHoras("jue", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respViernes = retornaHoras("vie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)

            def horasAcad = 0

            if(periodo.tipo == 'N') {
                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() +
                        (r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble())
            } else {
                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble()
            }

            Row rowF1 = sheet.createRow(fila)

            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.curso?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue(r?.curso?.nrc?.toString());

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.curso?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.curso?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.curso?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue(r?.curso?.paralelo?.numero?.toString())

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue(r?.curso?.asignatura?.horasTeoria?.toInteger())

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue(r?.curso?.asignatura?.horasPractica?.toInteger())

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.curso?.asignatura?.horasPractica?.toInteger() ?: 0) + (r?.curso?.asignatura?.horasTeoria?.toInteger() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue(respLunes);

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue(respMartes);

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue(respMiercoles);

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue(respJueves);

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue(respViernes);

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.curso?.asignatura?.creditos?.toDouble());

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.curso?.asignatura?.factorPreparacion?.toDouble());

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble());

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.curso?.asignatura?.horasGestion?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(horasAcad);

            suma += horasAcad
            fila++
        }

        gestion.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)


            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue("");

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue("")

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue("")

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue("")

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue("");

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue("");

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue("");

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue("");

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue("");

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.hora?.toDouble()?:'');

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.asignatura?.factorPreparacion?.toDouble()?:'');

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:'');

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.horas?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(r?.horas?.toDouble());

            fila++
            suma += r?.horas?.toDouble()
        }

        gestionN.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)

            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue("");

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue("")

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue("")

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue("")

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue("");

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue("");

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue("");

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue("");

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue("");

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.hora?.toDouble()?:'');

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            fila++
            suma += r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble()
        }

        Row rowF1 = sheet.createRow(fila)
        rowF1.createCell(18).setCellValue("Total")
        rowF1.createCell(19).setCellValue(suma)
        rowF1.setRowStyle(style)

        fila++

        if(suma > 40 && periodo.tipo == 'N') {
            Row rowS = sheet.createRow(fila)
            rowS.createCell(1).setCellValue("El valor de ${Math.round((suma - 40)*10)/10} horas, que sobrepasa a las " +
                    "40 horas semanales, se compensará en el periodo \"${p_hijo?.descripcion}\" como " +
                    "${Math.round((suma - 40)*(periodo.semanas/p_hijo.semanas)*10)/10} horas de trabajo")
            rowS.setRowStyle(style)
        }

        if(periodo.tipo == 'I') {
            sql = "select comphora from res_prdo_n(${profesor.id}, ${p_padre.id})"
            println "sql para ${periodo.tipo}: $sql"
            def hh = cn.rows(sql.toString())[0].comphora
            Row rowS = sheet.createRow(fila)
            rowS.createCell(1).setCellValue("Compensación del periodo \"${p_padre?.descripcion}\" ${hh} horas de trabajo")
            rowS.createCell(16).setCellValue("Compensación periodo ${p_padre?.descripcion}")
            rowS.createCell(19).setCellValue(hh)
            rowS.setRowStyle(style)
            Row rowS1 = sheet.createRow(fila + 1)
            rowS1.createCell(17).setCellValue("Total del periodo")
            rowS1.createCell(19).setCellValue(suma + hh)
            rowS1.setRowStyle(style)
        }


//        println "--> ${profesor?.apellido + "_" + profesor?.nombre}"
//        if(generaArch) {
//            def file = new File("/tmp/profesor_${profesor?.apellido + "_" + profesor?.nombre}.xlsx")
//            FileOutputStream outputStream = new FileOutputStream(file)
//            wb.write(outputStream)
//        } else {
//            def output = response.getOutputStream()
//            def header = "attachment; filename=" + "profesor_${profesor?.apellido + " " + profesor?.nombre}.xlsx";
//            response.setContentType("application/octet-stream")
//            response.setHeader("Content-Disposition", header);
//            wb.write(output)
//        }

        return fila
    }

    def profesoresHorario_ajax(){

    }

    def reporteProfesoresHorarioExcel(){
        println("reportePofesoresExcel " + params)
        def cn = dbConnectionService.getConnection()
        def sql = ""
        def prdo = Periodo.get(params.periodo)
        def fila = 4

        XSSFWorkbook wb = new XSSFWorkbook()
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setBold(true);
        style2.setFont(font2);
        style2.setAlignment(HorizontalAlignment.CENTER);

        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        style3.setWrapText(true);
        style3.setFont(font3);
        style3.setAlignment(HorizontalAlignment.LEFT);

        XSSFCellStyle style4 = wb.createCellStyle();
        XSSFFont font4 = wb.createFont();
        style4.setWrapText(true);
        style4.setFont(font4);
        style4.setAlignment(HorizontalAlignment.RIGHT);

        Sheet sheet = wb.createSheet("Período ${prdo.descripcion}")
        sheet.setColumnWidth(0, 9 * 256);
        sheet.setColumnWidth(1, 8 * 256);
        sheet.setColumnWidth(2, 8 * 256);
        sheet.setColumnWidth(3, 36 * 256);
        sheet.setColumnWidth(4, 36 * 256);
        sheet.setColumnWidth(5, 8 * 256);
        sheet.setColumnWidth(6, 8 * 256);
        sheet.setColumnWidth(7, 8 * 256);
        sheet.setColumnWidth(8, 8 * 256);
        sheet.setColumnWidth(9, 10 * 256);
        sheet.setColumnWidth(10, 10 * 256);
        sheet.setColumnWidth(11, 10 * 256);
        sheet.setColumnWidth(12, 10 * 256);
        sheet.setColumnWidth(13, 10 * 256);
        sheet.setColumnWidth(14, 10 * 256);
        sheet.setColumnWidth(15, 10 * 256);
        sheet.setColumnWidth(16, 10 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 10 * 256);
        sheet.setColumnWidth(19, 10 * 256);

        Row row = sheet.createRow(0)
        row.createCell(0).setCellValue("")
        Row row2 = sheet.createRow(1)
//        if(params.profesor != 'null') {
//            def profesorNombre = Profesor.get(params.profesor)
//            row2.createCell(0).setCellValue("DOCENTE")
//            row2.createCell(1).setCellValue(profesorNombre?.apellido + " " + profesorNombre?.nombre)
//            row2.createCell(4).setCellValue("Período: ${prdo.descripcion}")
//        }else{
            row2.createCell(1).setCellValue("LISTA DE DOCENTES")
//        }
        row2.setRowStyle(style)
        Row row4 = sheet.createRow(3)
        row4.createCell(0).setCellValue("Fecha:")
        row4.createCell(1).setCellValue(new Date().format("dd-MM-yyyy"))
//        row4.sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
        fila++

        Row rowC1 = sheet.createRow(fila)
        rowC1.createCell(0).setCellValue("Carrera")
        rowC1.createCell(1).setCellValue("NRC")
        rowC1.createCell(2).setCellValue("Código Banner")
        rowC1.createCell(3).setCellValue("Nombre Asignatura o Actividad")
        rowC1.createCell(4).setCellValue("Docente")
        rowC1.createCell(5).setCellValue("Nivel")
        rowC1.createCell(6).setCellValue("Paralelo")
        rowC1.createCell(7).setCellValue("Teoría")
        rowC1.createCell(8).setCellValue("Práctica")
        rowC1.createCell(9).setCellValue("Horas Semana")
        rowC1.createCell(10).setCellValue("Lunes ")
        rowC1.createCell(11).setCellValue("Martes")
        rowC1.createCell(12).setCellValue("Miércoles")
        rowC1.createCell(13).setCellValue("Jueves")
        rowC1.createCell(14).setCellValue("Viernes")
        rowC1.createCell(15).setCellValue("Créditos")
        rowC1.setRowStyle(style)
        fila++

        def profesor
        def dicta
        def gestion = []
        def gestionN = []
        def parl
        def crso
        def suma = 0

        println "haciendo el reporte"

//        if(params.profesor != 'null'){
////            profesor = Profesor.get(params.profesor)
//            return reporteExcel(prdo?.id, params.profesor, false)
////            if(prdo.tipo == 'N'){
////                parl = Paralelo.findAllByPeriodo(prdo)
////                crso = Curso.findAllByParaleloInList(parl)
////                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
////                gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)
////            } else {
////                parl = Paralelo.findAllByPeriodo(prdo.padre)
////                crso = Curso.findAllByParaleloInList(parl)
////                dicta = Dicta.findAllByProfesorAndCursoInList(profesor, crso)
////                gestionN = Gestion.findAllByProfesorAndPeriodo(profesor, prdo.padre)
////            }
////            println "dicta: $dicta"
////            gestion = Gestion.findAllByProfesorAndPeriodo(profesor, prdo)
//        }else{
////            return imprimeExcel(prdo?.id);
//            return reporteExcel(prdo?.id, 2, true)
////            parl = Paralelo.findAllByPeriodo(prdo)
////            crso = Curso.findAllByParaleloInList(parl)
////            dicta = Dicta.findAllByCursoInList(crso)
//        }

        parl = Paralelo.findAllByPeriodo(prdo)
        crso = Curso.findAllByParaleloInList(parl)
        dicta = Dicta.findAllByCursoInList(crso)

        dicta.eachWithIndex { r, j ->
            def respLunes = retornaHoras("lun", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respMartes = retornaHoras("mar", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respMiercoles = retornaHoras("mie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respJueves = retornaHoras("jue", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)
            def respViernes = retornaHoras("vie", r?.curso?.asignatura?.nivel?.id, r?.curso?.paralelo?.id, r?.curso?.asignatura?.id)

            def horasAcad = 0

            if(prdo.tipo == 'N') {
                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() +
                        (r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble())
            } else {
                horasAcad = r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble()
            }

            Row rowF1 = sheet.createRow(fila)

            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.curso?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue(r?.curso?.nrc?.toString());

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.curso?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.curso?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.curso?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue(r?.curso?.paralelo?.numero?.toString())

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue(r?.curso?.asignatura?.horasTeoria?.toInteger())

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue(r?.curso?.asignatura?.horasPractica?.toInteger())

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.curso?.asignatura?.horasPractica?.toInteger() ?: 0) + (r?.curso?.asignatura?.horasTeoria?.toInteger() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue(respLunes);

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue(respMartes);

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue(respMiercoles);

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue(respJueves);

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue(respViernes);

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.curso?.asignatura?.creditos?.toDouble());

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.curso?.asignatura?.factorPreparacion?.toDouble());

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.curso?.asignatura?.creditos?.toInteger() * r?.curso?.asignatura?.factorPreparacion?.toDouble());

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.curso?.asignatura?.horasGestion?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(horasAcad);

            suma += horasAcad
            fila++
        }

        gestion.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)


            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue("");

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue("")

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue("")

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue("")

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue("");

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue("");

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue("");

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue("");

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue("");

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.hora?.toDouble()?:'');

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.asignatura?.factorPreparacion?.toDouble()?:'');

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:'');

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.horas?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(r?.horas?.toDouble());

            fila++
            suma += r?.horas?.toDouble()
        }

        gestionN.eachWithIndex { r, j ->
            Row rowF1 = sheet.createRow(fila)



            Cell cell0 = rowF1.createCell(0);
            cell0.setCellStyle(style3);
            cell0.setCellValue(r?.asignatura?.carrera?.codigo?.toString());

            Cell cell1 = rowF1.createCell(1);
            cell1.setCellStyle(style3);
            cell1.setCellValue("");

            Cell cell2 = rowF1.createCell(2);
            cell2.setCellStyle(style3);
            cell2.setCellValue(r?.asignatura?.codigo?.toString());

            Cell cell3 = rowF1.createCell(3);
            cell3.setCellStyle(style3);
            cell3.setCellValue(r?.asignatura?.nombre?.toString());

            Cell cell4 = rowF1.createCell(4);
            cell4.setCellStyle(style3);
            cell4.setCellValue(r?.profesor?.apellido?.toString() + " " + r?.profesor?.nombre?.toString())

            Cell cell5 = rowF1.createCell(5);
            cell5.setCellStyle(style3);
            cell5.setCellValue(r?.asignatura?.nivel?.numero?.toString())

            Cell cell6 = rowF1.createCell(6);
            cell6.setCellStyle(style3);
            cell6.setCellValue("")

            Cell cell7 = rowF1.createCell(7);
            cell7.setCellStyle(style4);
            cell7.setCellValue("")

            Cell cell8 = rowF1.createCell(8);
            cell8.setCellStyle(style4);
            cell8.setCellValue("")

            Cell cell9 = rowF1.createCell(9);
            cell9.setCellStyle(style4);
            cell9.setCellValue((r?.asignatura?.horasGestion?.toDouble() ?: 0))

            Cell cell10 = rowF1.createCell(10);
            cell10.setCellStyle(style3);
            cell10.setCellValue("");

            Cell cell11 = rowF1.createCell(11);
            cell11.setCellStyle(style3);
            cell11.setCellValue("");

            Cell cell12 = rowF1.createCell(12);
            cell12.setCellStyle(style3);
            cell12.setCellValue("");

            Cell cell13 = rowF1.createCell(13);
            cell13.setCellStyle(style3);
            cell13.setCellValue("");

            Cell cell14 = rowF1.createCell(14);
            cell14.setCellStyle(style3);
            cell14.setCellValue("");

            Cell cell15 = rowF1.createCell(15);
            cell15.setCellStyle(style4);
            cell15.setCellValue(r?.hora?.toDouble()?:'');

            Cell cell16 = rowF1.createCell(16);
            cell16.setCellStyle(style4);
            cell16.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell17 = rowF1.createCell(17);
            cell17.setCellStyle(style4);
            cell17.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell18 = rowF1.createCell(18);
            cell18.setCellStyle(style4);
            cell18.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());

            Cell cell19 = rowF1.createCell(19);
            cell19.setCellStyle(style4);
            cell19.setCellValue(r?.hora?.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble());


//            rowF1.createCell(19).setCellValue(r?.hora.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble())
//            rowF1.setRowStyle(style3)

            fila++
            suma += r?.hora.toDouble() * r?.asignatura?.factorPreparacion?.toDouble()?:r?.hora?.toDouble()
        }

//        suma = 41.2 //borrar

        Row rowF1 = sheet.createRow(fila)
        rowF1.createCell(18).setCellValue("Total")
        rowF1.createCell(19).setCellValue(suma)
        rowF1.setRowStyle(style)

        fila++



//        if(suma > 40 && prdo.tipo == 'N') {
//            Row rowS = sheet.createRow(fila)
//            rowS.createCell(1).setCellValue("El valor de ${Math.round((suma - 40)*10)/10} horas, que sobrepasa a las " +
//                    "40 horas semanales, se compensará en el periodo \"${p_hijo?.descripcion}\" como " +
//                    "${Math.round((suma - 40)*(prdo.semanas/p_hijo.semanas)*10)/10} horas de trabajo")
//            rowS.setRowStyle(style)
//        }

//        if(prdo.tipo == 'I') {
//            sql = "select comphora from res_prdo_n(${profesor.id}, ${p_padre.id})"
//            println "sql para ${prdo.tipo}: $sql"
//            def hh = cn.rows(sql.toString())[0].comphora
//            Row rowS = sheet.createRow(fila)
//            rowS.createCell(1).setCellValue("Compensación del periodo \"${p_padre?.descripcion}\" ${hh} horas de trabajo")
//            rowS.createCell(16).setCellValue("Compensación periodo ${p_padre?.descripcion}")
//            rowS.createCell(19).setCellValue(hh)
//            rowS.setRowStyle(style)
//            Row rowS1 = sheet.createRow(fila + 1)
//            rowS1.createCell(17).setCellValue("Total del periodo")
//            rowS1.createCell(19).setCellValue(suma + hh)
//            rowS1.setRowStyle(style)
//        }

        def output = response.getOutputStream()
        def header = "attachment; filename=" + "todosHorario.xlsx";
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", header);
        wb.write(output)

    }

}