/*
 * Weak Reference�� �̿��� HashMap
 */

package item7;

import java.util.Map;
import java.util.WeakHashMap;

public class ClassWeakHashMap {
    public static class Referred {
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }

    /**
    * GC�� �߻� ���� �޸𸮸� ȸ���ϴ� �ڵ�
    * System.gc()�� �� ���������� �𸣰ڴ�.
    */
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(5000);
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Creating weak references");

        // This is now a weak reference. 
        // The object will be collected only if no strong references. 
        Referred strong = new Referred(); //Strong Reference�� �ϳ� �߰�

        //Weak Reference�� �̿��� WeakHashMap�� ��Ʈ���� �߰��Ͽ�
        //Weak Reference �߰�
        Map<Referred, String> metadata = new WeakHashMap<Referred, String>();
        metadata.put(strong, "WeakHashMap's make my world go around");

        // Attempt to claim a suggested reference. 
        ClassWeakHashMap.collect();
        //���⼭�� gc�� �߻��ص� GC����� �ƴϰ� �ȴ�.
        //strong�̶�� ������ ���� Strong Reference�� �����Ƿ� GC ����� �ƴϴ�.
        System.out.println("Still has metadata entry? " + (metadata.size() == 1));
        System.out.println("Removing reference");

        // The object may be collected. 
        //Strong Reference�� ������.
        strong = null;

        //���⼭�� Weak Reference�� ���� �ֱ� ������ GC����� �ȴ�.
        ClassWeakHashMap.collect();
        System.out.println("Still has metadata entry? " + (metadata.size() == 1));
        System.out.println("Done");
    }
}