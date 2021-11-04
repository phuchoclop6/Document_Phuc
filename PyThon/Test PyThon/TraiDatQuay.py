import time
from tkinter import*
from PIL import Image, ImageTk

class RotarImagen(object):
	"""docstring for RotarImagen"""
	def __init__(self, master, archivo):
		self.master = master
		self.archivo = archivo
		self.canvas = Canvas(master, width=500, height=500)
		self.canvas.pack()

		self.siguiente = self.rotar().__next__
		master.after(1, self.siguiente)

	def rotar(self):
		image = Image.open(self.archivo)
		angle = 0
		while True:
			tkimage = ImageTk.PhotoImage(image.rotate(angle))
			canvas_obj = self.canvas.create_image(250, 250, image=tkimage)
			self.master.after_idle(self.siguiente)
			yield
			self.canvas.delete(canvas_obj)
			angle += 1
			angle %= 360
			time.sleep(0.002)
ventana = Tk()
app = RotarImagen(ventana, 'traidat.png')
ventana.mainloop()