// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AppointmentService.proto

package generated.grpc.AppointmentService;

public final class AppointmentServiceImpl {
  private AppointmentServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppointmentService_AppointmentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AppointmentService_AppointmentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppointmentService_AppointmentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AppointmentService_AppointmentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppointmentService_AvailabilityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AppointmentService_AvailabilityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppointmentService_AvailabilityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AppointmentService_AvailabilityResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030AppointmentService.proto\022\022AppointmentS" +
      "ervice\"N\n\022AppointmentRequest\022\022\n\npatient_" +
      "id\030\001 \001(\t\022\021\n\tdoctor_id\030\002 \001(\t\022\021\n\tdate_time" +
      "\030\003 \001(\t\"7\n\023AppointmentResponse\022\017\n\007success" +
      "\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\"(\n\023AvailabilityR" +
      "equest\022\021\n\tdoctor_id\030\001 \001(\t\")\n\024Availabilit" +
      "yResponse\022\021\n\tdate_time\030\001 \001(\t2\344\001\n\022Appoint" +
      "mentService\022f\n\023ScheduleAppointment\022&.App" +
      "ointmentService.AppointmentRequest\032\'.App" +
      "ointmentService.AppointmentResponse\022f\n\017G" +
      "etAvailability\022\'.AppointmentService.Avai" +
      "labilityRequest\032(.AppointmentService.Ava" +
      "ilabilityResponse0\001B=\n!generated.grpc.Ap" +
      "pointmentServiceB\026AppointmentServiceImpl" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_AppointmentService_AppointmentRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AppointmentService_AppointmentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AppointmentService_AppointmentRequest_descriptor,
        new java.lang.String[] { "PatientId", "DoctorId", "DateTime", });
    internal_static_AppointmentService_AppointmentResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_AppointmentService_AppointmentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AppointmentService_AppointmentResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
    internal_static_AppointmentService_AvailabilityRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_AppointmentService_AvailabilityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AppointmentService_AvailabilityRequest_descriptor,
        new java.lang.String[] { "DoctorId", });
    internal_static_AppointmentService_AvailabilityResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_AppointmentService_AvailabilityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AppointmentService_AvailabilityResponse_descriptor,
        new java.lang.String[] { "DateTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
