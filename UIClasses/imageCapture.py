import cv2

def main():
    camera = cv2.VideoCapture(0)

    print("Capturing")

    while True:
        ret, frame = camera.read()

        cv2.imwrite("image.jpg", frame)

if __name__ == "__main__":
    main()