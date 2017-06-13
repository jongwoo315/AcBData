from django.contrib import admin
from .models import Sungjuk
admin.site.register(Sungjuk)

@property
def avg(self):
    return round((self.kor + self.mat + self.eng) / 3, 2)
def get_absolute_url(self):
    return reverse('server_edit', kwargs={'pk':self.pk})
class Meta:
    verbose_name = 'sungjuk'
    verbose_name_plural = 'sungjuks'
    ordering = ['name']
