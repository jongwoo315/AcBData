from __future__ import unicode_literals
from django.db import models


class Sungjuk(models.Model):
    name = models.CharField(max_length=50, unique=False)
    kor = models.IntegerField()
    eng = models.IntegerField()
    mat = models.IntegerField()
    tot = models.FloatField()
    avg = models.FloatField()

    def __str__(self):
        return self.name

    @property
    def tot(self):
        return self.kor + self.mat + self.eng

    def avg(self):
        return round((self.kor + self.mat + self.eng) / 3, 2)

    def get_absolute_url(self):
        return reverse('server_edit', kwargs={'pk':self.pk})

    class Meta:
        verbose_name = 'sungjuk'
        verbose_name_plural = 'sungjuks'
        ordering = ['name']
