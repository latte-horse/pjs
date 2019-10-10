import os
from datetime import datetime

def make_folder(folder_name) :
    if not os.path.isdir(folder_name) :
        os.mkdir(folder_name)

datetime = datetime.now()
day = "%s%s%s" % (datetime.year, datetime.month, datetime.day)
today = day[2:8]
CurrentTime = "%s%s" % (datetime.hour, datetime.minute)

root_dir = "C:/after"
day_dir = root_dir + "/" + today
time_dir = day_dir + "/" + CurrentTime

make_folder(day_dir)
make_folder(time_dir)

