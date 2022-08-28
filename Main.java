import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void  main(String[] args) {
        Device[] devices = new Device[20];
        boolean finished = false;
        int registeredDevices = 0;

        while (!finished) {
            int action;
            System.out.println("\nDispositivos registrados: " + registeredDevices);
            if(registeredDevices < devices.length) {
            System.out.println("1: Registrar");
            }
            System.out.println("2: Buscar");
            System.out.println("3: Consultar");
            System.out.println("0: Terminar");
            action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    if(registeredDevices < devices.length) {
                        devices[registeredDevices] = register();
                        registeredDevices++;
                        System.out.println("Dispositivo registrado correctamente");
                    }
                    else {
                        System.out.println("Limite de dispositivos alcanzado");
                    }
                    break;
                case 2:
                    lookFor(devices, registeredDevices);
                    break;
                case 3:
                    consult(devices, registeredDevices);
                    break;
                case 0:
                    finished = true;
                    System.out.println("Terminado");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    public static Device register() {
        String name, kind, brand;
        System.out.println("Nombre: ");
        name = input.nextLine();
        System.out.println("Tipo de dispositivo: ");
        kind = input.nextLine();
        System.out.println("Marca: ");
        brand = input.nextLine();

        return new Device(name, kind, brand);
    }

    public static void edit(Device[] devices, int index) {
        boolean finished = false;
        while(!finished) {
            int action;
            devices[index].showInfo();
            System.out.println("\n1: Editar");
            System.out.println("0: Regresar");
            action = input.nextInt();
            input.nextLine();
            switch (action) {
                case 1 -> {
                    System.out.println("Tipo: ");
                    devices[index].setKind(input.nextLine());
                    System.out.println("Marca: ");
                    devices[index].setBrand(input.nextLine());
                    System.out.println("Datos modificados correctamente");
                }
                case 0 -> finished = true;
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    public static void lookFor(Device[] devices, int registeredDevices) {
        String device;
        System.out.println("Dispositivo: ");
        device = input.nextLine();
        boolean foundTarget = false;
        for(int i = 0; i < registeredDevices; i++) {
            if(devices[i].getName().equals(device)) {
                edit(devices, i);
                foundTarget = true;
                break;
            }
        }
        if(!foundTarget) {
            System.out.println("El dispositivo " + device + " no esta registrado");
        }
    }

    public static void consult(Device[] devices, int registeredDevices){
        for (int i = 1; i <= registeredDevices; i++) {
            System.out.println("\n----------Dispositivo " + i + "----------");
            devices[i - 1].showInfo();
        }
    }
}
