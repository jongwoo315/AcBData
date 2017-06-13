import csv
from django.http import HttpResponse
from django.http import response
def csv_view(request):
    response = HttpResponse(content='text/csv')
    response['Content-Disposition'] = 'attachment; filename="csvfilename.csv"'

    writer = csv.writer(response)
    writer.writerow(['First row', 'Foo', 'Bar', 'Baz'])
    writer.writerow(['Second row', 'A', 'B', 'C', '"Testing"', "Here's a quote"])
    return response

from openpyxl import Workbook
def export_to_excel(request): # 성적프로그램에 있는 내용을 엑셀파일로 만드시오
    excel_data = [
        ['header1', 'header2', 'header3', 'header4', 'header5'],
        [1, 4, 5, 6, 7],
        [5, 6, 2, 4, 8]
    ]
    if excel_data:
        wb = Workbook(write_only=True)
        ws = wb.create_sheet()
        for line in excel_data:
            ws.append(line)

    response = HttpResponse(content_type='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')
    response['Content-Disposition'] = 'attachment; filename=mydate.xlsx'
    wb.save(response)
