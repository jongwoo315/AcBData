#-*-encoding:utf-8-*-
from import_export import resources
from .models import Sungjuk


# 파일 다운로드나 업로드에 사용
class SungjukResource(resources.ModelResource):
    class Meta:
        model = Sungjuk
