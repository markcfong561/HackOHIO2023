import cv2

def main():
    camera = cv2.VideoCapture(0)

    while True:
        ret, frame = camera.read()

        cv2.imwrite("UIClasses/image.jpg", frame)

if __name__ == "__main__":
    main()